import { Component } from '@angular/core';
import { RecommendedTool } from '../interfaces/RecommendedTool';
import { OverviewService } from '../services/API/overview.service';
import { UserTokenService } from '../services/token/user-token.service';
import { NavStateService } from '../services/Helper/nav-state.service';
import { AuthService } from '../services/auth/auth.service';

@Component({
  selector: 'app-overview',
  templateUrl: './overview.component.html',
  styleUrls: ['./overview.component.css']
})
export class OverviewComponent {

  personalRecommendations: RecommendedTool[];
  allRecommendations: RecommendedTool[];
  showPersonal: boolean = true;

  constructor(private overviewService: OverviewService, private authService: AuthService, public navState: NavStateService) {

    this.overviewService.getRecommendationsForCurrentUser(this.getUidCurrentUser())
      .subscribe((response) => {
        // put the newest first
        this.personalRecommendations = response.reverse();
      })

      this.overviewService.getAllRecommendations()
      .subscribe((response) => {
        // put the newest first
        this.allRecommendations = response.reverse();
      })
  }

  ngOnInit() {
  }

  showPersonalRecommendations() {
    this.showPersonal = true;
  }

  showAll() {
    this.showPersonal = false;
  }

  getUidCurrentUser(): string{
    
    if (this.authService.getCurrentUser().oid == null) {  
      return this.authService.getCurrentUser().user_id;
    }
    return this.authService.getCurrentUser().oid;
  }

}
