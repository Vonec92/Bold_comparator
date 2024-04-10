import { Injectable } from '@angular/core';
import { MatSnackBar, MatSnackBarVerticalPosition } from '@angular/material/snack-bar';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private snackBar: MatSnackBar) { }

  // css classes for snackbar in styles.css (BBRecommenderFE\src\styles.css)

  // standard success snackbar 
  showGreenSnackbar(message: string = "Succes", btnAction: string = "Close", duration: number = 1000, verticalPos: MatSnackBarVerticalPosition = 'top') {
    this.snackBar.open(message, btnAction, {
      duration: duration,
      verticalPosition: verticalPos,
      panelClass: ['green-snackbar']
    });
  }

  // standard error snackbar
  showRedSnackbar(message: string = "failed", btnAction: string = "Close", duration: number = 1000, verticalPos: MatSnackBarVerticalPosition = 'top') {
    this.snackBar.open(message, btnAction, {
      duration: duration,
      verticalPosition: verticalPos,
      panelClass: ['red-snackbar']
    });
  }

}
