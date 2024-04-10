import { Component } from '@angular/core';
import { AuthService } from '../services/auth/auth.service';
import { RecommendedTool } from '../interfaces/RecommendedTool';
import { NotificationService } from '../services/Helper/notification.service';
import { NavStateService } from '../services/Helper/nav-state.service';
import { Router } from '@angular/router';
import { FilterOptions } from '../interfaces/FilterOptions';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { RecommendationService } from '../services/API/recommendation.service';
import { CurrentDateService } from '../services/Helper/current-date.service';
import { Observable, catchError } from 'rxjs';

@Component({
  selector: 'app-recommendation-page',
  templateUrl: './recommendation-page.component.html',
  styleUrls: ['./recommendation-page.component.css']
})
export class RecommendationPageComponent {

  currentDateJson: string;
  filterOptions: FilterOptions;
  form: FormGroup;
  isSaving : boolean= false;
  isProcessing : boolean = false;
  isValidInput: boolean = false;

  recommendedToolName: string;

  constructor(private RecommendationService: RecommendationService, private authService: AuthService, private notificationService: NotificationService, public navState: NavStateService, private router: Router, private formBuilder: FormBuilder, private currentDateService: CurrentDateService) {
    this.currentDateJson = this.currentDateService.getCurrentDate();

    this.recommendedToolName = "unknown";
  }

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      companyName: ['', Validators.required],
    })
  }

  onSave() {
    let recommendedTool: RecommendedTool = {
      "uid": this.getUidCurrentUser(),
      "creator": this.getCurrentUserName(),
      "date": this.currentDateJson,
      "toolName": this.recommendedToolName,
      "companyName": this.form.value.companyName.trim(), // trim to remove whitespaces from beginning and end
      "filterOptions": this.filterOptions,
    }

    console.log(recommendedTool);

    this.RecommendationService.SaveRecommendedTool(recommendedTool).pipe(
      catchError((err, caught) => {
        console.log(err);
        this.notificationService.showRedSnackbar(err.error.message, "Close", 2000, 'top');
        return new Observable();
      })
    ).subscribe(response => {
      console.log(response);
      this.notificationService.showGreenSnackbar("Recommended tool saved!", "Close", 2000, 'top');
    });

    

    this.isSaving = true;

    setTimeout(() => { this.router.navigate(['/overview']); }, 1000);

  }

  OnCancel(): void {
    this.notificationService.showRedSnackbar("Recommendation cancelled", "Close", 2000, 'top');
  }

  /* child components functions */

  SetRecommendedTool(filterTool: FilterOptions): void {
    this.filterOptions = filterTool;
  
    console.log(this.filterOptions);
    // calculate score of selected tool
    this.RecommendationService.getRecommendedToolNameForUserInput(this.filterOptions).subscribe(response => {
      this.isProcessing = true;

      setTimeout(() => { this.isProcessing = false; }, 1000);

      this.recommendedToolName = response.toolName;
    });
  }

  setIsValid(isValid: boolean): void {

    this.isValidInput = isValid;
  }


  /* User functions */

  getUidCurrentUser(): string {

    if (this.authService.getCurrentUser().oid == null) {
      return this.authService.getCurrentUser().user_id;
    }

    return this.authService.getCurrentUser().oid;

  }

  getCurrentUserName(): string {

    if (this.authService.getCurrentUser().name == null) {

      return this.getUserNameOutOfEmail(this.authService.getCurrentUser().email);
    }

    return this.authService.getCurrentUser().name;

  }

  getUserNameOutOfEmail(email: string): string {
    return email.split("@")[0].replace(".", " ");
  }

}
