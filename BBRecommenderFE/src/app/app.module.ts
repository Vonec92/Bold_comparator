import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { MatSliderModule } from '@angular/material/slider';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { initializeApp, provideFirebaseApp } from '@angular/fire/app';
import { provideAuth, getAuth } from '@angular/fire/auth';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { environment } from "src/environments/environment.production";
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { MatRadioModule } from '@angular/material/radio';
import {MatTabsModule} from '@angular/material/tabs';
import { MatSelectModule } from '@angular/material/select';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { StartPageComponent } from './start-page/start-page.component';
import { OverviewComponent } from './overview/overview.component';
import { DetailPageComponent } from './detail-page/detail-page.component';
import { OverviewTableComponent } from './overview-table/overview-table.component';
import { FaqComponent } from './faq/faq.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { FilterBarComponent } from './filter-bar/filter-bar.component';
import { HttpCacheInterceptor } from './interceptor/http-cache.interceptor';
import { SignInFormComponent } from './sign-in-form/sign-in-form.component';
import { BebotComponent } from './bebot/bebot.component';
import { RecommendationPageComponent } from './recommendation-page/recommendation-page.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    StartPageComponent,
    OverviewComponent,
    DetailPageComponent,
    OverviewTableComponent,
    FaqComponent,
    SidebarComponent,
    FilterBarComponent,
    SignInFormComponent,
    BebotComponent,
    RecommendationPageComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    NgbModule,
    DragDropModule,
    MatSliderModule,
    MatCardModule,
    MatFormFieldModule,
    HttpClientModule,
    MatSnackBarModule,
    MatSidenavModule,
    BrowserAnimationsModule,
    MatToolbarModule,
    MatIconModule,
    MatListModule,
    MatTableModule,
    MatPaginatorModule,
    MatInputModule,
    MatButtonModule,
    MatGridListModule,
    MatProgressSpinnerModule,
    MatRadioModule,
    MatSelectModule,
    MatTabsModule,
    provideFirebaseApp(() => initializeApp(environment.firebase)),
    provideAuth(() => getAuth()),




  ],
  providers: [ {
                provide: HTTP_INTERCEPTORS,
                useClass: HttpCacheInterceptor,
                multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
