import { Injectable, Optional } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { Auth } from '@angular/fire/auth';
import { signInWithPopup, OAuthProvider, signOut, signInWithEmailAndPassword,  onAuthStateChanged } from "firebase/auth";
import { MicrosoftLoginResponse } from 'src/app/interfaces/MicrosoftLoginResponse';
import { User } from 'src/app/interfaces/User';
import { UserTokenService } from '../token/user-token.service';


const provider = new OAuthProvider('microsoft.com');
// Parameters to ask consent, set login to only cronos.be
provider.setCustomParameters({
  prompt: "consent",
  tenant: "cronos.be",
  login_hint: '@cronos.be'
})
provider.addScope('mail.read');

@Injectable({
  providedIn: 'root'
})

export class AuthService {

  userLoggedIn = false;

  constructor(@Optional() private Afauth: Auth, private router: Router, private _http: HttpClient, private userTokenService: UserTokenService) {

    onAuthStateChanged(this.Afauth, (user) => {
      if (user) {
        this.userLoggedIn = true;
      } else {
        this.userLoggedIn = false;
      }
    });
  }

  async microsoftLogin(): Promise<MicrosoftLoginResponse> {
    await signInWithPopup(this.Afauth, provider)
      .then((data) => {

        // User is signed in.
        const credential = OAuthProvider.credentialFromResult(data);
        let idToken = credential.idToken;

        this.userTokenService.setJWt(idToken);

      })
      .catch((error) => {
        // Handle error.
        return { isValid: false, message: error.message }
      });

    return { isValid: true, message: "User is logged in" };
  }

  async emailPasswordLogin(email: string, password: string): Promise<MicrosoftLoginResponse> {
    await signInWithEmailAndPassword(this.Afauth, email, password)
      .then((userCredential) => {
        // Get the access token.
        return userCredential.user.getIdToken();
      })
      .then((accessToken) => {
        this.userTokenService.setJWt(accessToken);
      })
      .catch((error) => {
        // Handle error.
        return { isValid: false, message: error.message };
      });
      return { isValid: true, message: "User is logged in" };
  }

  getCurrentUser(): User {
    return this.userTokenService.getCurrentUser();
  }

  logout() {
    signOut(this.Afauth).then(() => {
      // Sign-out successful.
      this.userTokenService.removeCurrentUser();
      this.router.navigate(['/login']);
    }).catch((error) => {
      // An error happened.
      console.log(error);
    })

  }
}



