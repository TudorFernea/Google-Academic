import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { DragDropModule } from '@angular/cdk/drag-drop';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { StudentPageComponentComponent } from './student-page/student-page-component.component';
import { EnrolPageComponent } from './enrol-page/enrol-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ViewCurriculumComponent } from './view-curriculum/view-curriculum.component';
import { ChooseYearOfStudyComponent } from './choose-year-of-study/choose-year-of-study.component';
import { SeeOptionalDisciplinesComponent } from './see-optional-disciplines/see-optional-disciplines.component';
import { ViewGradesComponent } from './view-grades/view-grades.component';
import { JwtModule } from '@auth0/angular-jwt';
import { AuthService } from './Servicies/auth.service';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    StudentPageComponentComponent,
    EnrolPageComponent,
    ViewCurriculumComponent,
    ChooseYearOfStudyComponent,
    SeeOptionalDisciplinesComponent,
    ViewGradesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    DragDropModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: AuthService.getAccessToken,
        allowedDomains: ['localhost:8080'],
        skipWhenExpired: true
      }
    }),
    
  ],
  exports:[RouterModule],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
