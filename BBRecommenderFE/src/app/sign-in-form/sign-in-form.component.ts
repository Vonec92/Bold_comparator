import { Component } from '@angular/core';
import { AuthService } from '../services/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-in-form',
  templateUrl: './sign-in-form.component.html',
  styleUrls: ['./sign-in-form.component.css']
})
export class SignInFormComponent {

  email: string;
  password: string;

  firebaseErrorMessage: string;

  constructor(private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {}

  microsoftLogin() {
    this.authService.microsoftLogin()
      .then((result) => {

        if (result.isValid) {
          console.log("User is logged in");
          this.router.navigate(['/start']);
        }
        else {
          this.firebaseErrorMessage = result.message;
        }
      }
      ).catch((error) => {
        this.firebaseErrorMessage = error.message;
      }
      );
  }

  emailPasswordLogin() {
    this.authService.emailPasswordLogin(this.email, this.password)
      .then((result) => {
        console.log(result);
        if (result.isValid) {
          console.log("User is logged in");
          this.router.navigate(['/start']);
        }
        else {
          this.firebaseErrorMessage = result.message;
        }
      }
      ).catch((error) => {
        this.firebaseErrorMessage = error.message;
      }
      );
  }

 
}
