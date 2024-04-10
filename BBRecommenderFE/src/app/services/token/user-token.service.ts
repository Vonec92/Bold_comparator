import { Injectable } from '@angular/core';
import { User } from 'src/app/interfaces/User';
import jwt_decode from "jwt-decode";

// const CURRENT_USER_TOKEN_KEY = 'auth-token';
const JWT_TOKEN_KEY = 'jwt-token';      


@Injectable({
  providedIn: 'root'
})
export class UserTokenService {

  constructor() { }

  setJWt(token: string) {
    localStorage.setItem(JWT_TOKEN_KEY, token);
  }

  getDecodedJwtToken():User {
    let token = localStorage.getItem(JWT_TOKEN_KEY);
    return token ? jwt_decode(token) : null;
  }

  getCurrentUser() :User {
    let user = this.getDecodedJwtToken();
    
    return user ? user : null;

  }

  removeCurrentUser() {
    localStorage.removeItem(JWT_TOKEN_KEY);
  }

  isLoggedIn() {
    return !!this.getCurrentUser();
  }

}
