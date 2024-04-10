import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { StartPageComponent } from './start-page/start-page.component';
import { OverviewComponent } from './overview/overview.component';
import { DetailPageComponent } from './detail-page/detail-page.component';
import { AuthGuard } from './services/auth/auth.guard';
import { FaqComponent } from './faq/faq.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { RecommendationPageComponent } from './recommendation-page/recommendation-page.component';


const routes: Routes = [

  { path: 'start', component: StartPageComponent, canActivate: [AuthGuard] },
  { path: 'overview', component: OverviewComponent, canActivate: [AuthGuard]},
  { path: 'overview/:id', component: DetailPageComponent, canActivate: [AuthGuard]},
  { path: 'overview/personal', component: DetailPageComponent, canActivate: [AuthGuard]},
  { path: 'overview/all', component: DetailPageComponent, canActivate: [AuthGuard]},
  { path: 'start-test', component: RecommendationPageComponent, canActivate: [AuthGuard] },
  { path: 'FAQ', component: FaqComponent, canActivate: [AuthGuard]},
  { path: 'sidebar', component: SidebarComponent},
  { path: 'login', component: LoginComponent},
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: '**', redirectTo: 'login' }



];

@NgModule({
  imports: [RouterModule.forRoot(routes,{useHash: true})],
  exports: [RouterModule]
})
export class AppRoutingModule { }
