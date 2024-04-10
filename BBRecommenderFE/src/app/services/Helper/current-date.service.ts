import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CurrentDateService {

  constructor() { }

  getCurrentDate() {
    const date = new Date();
    const year = date.getFullYear().toString();
    const month = (date.getMonth() + 1).toString().padStart(2, '0'); // add zero if needed
    const day = date.getDate().toString().padStart(2, '0'); // add zero if needed
    
    return `${year}-${month}-${day}`;
  }

}
