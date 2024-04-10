import { Injectable, Optional } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate , Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import {Auth} from '@angular/fire/auth';
import { UserTokenService } from '../token/user-token.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate  {

  constructor(
    @Optional() private auth: Auth,
    private router: Router,
    private userTokenService: UserTokenService
  ) { }

  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

    return new Promise((resolve, reject) => {

      this.auth.onAuthStateChanged(user => {
        if (user && this.userTokenService.isLoggedIn()){ 
            resolve(true);
        }
        else {
            this.router.navigate(['/login']);
            resolve(false);
          }
    })})

  } 
}
