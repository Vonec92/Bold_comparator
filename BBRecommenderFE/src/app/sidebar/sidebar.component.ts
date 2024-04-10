import { Component, EventEmitter, Input, Output } from '@angular/core';
import { AuthService } from '../services/auth/auth.service';

import { User } from '../interfaces/User';
import { NotificationService } from '../services/Helper/notification.service';



@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent {

  public currentUser: User;

  constructor(private authService : AuthService, private notificationService: NotificationService) { 
    this.currentUser = this.authService.getCurrentUser();
  }

   logout(): void {

    this.notificationService.showGreenSnackbar("Logging out", "Close", 1000 , 'bottom');

    setTimeout( () => {
      this.authService.logout();
    }, 1001);
  
  }

  getNameOutOfMail(): string {
    return this.currentUser.email.split('@')[0];
  }

  ngOnInit(): void { }
 
  

}
