import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NavStateService {

  public navState: boolean = true;

  constructor() { }

  changeNavState() {
    this.navState = !this.navState;
  }
}
