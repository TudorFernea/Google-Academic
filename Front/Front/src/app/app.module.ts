import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
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
import { ChooseYearOfStudy2Component } from './choose-year-of-study2/choose-year-of-study2.component';
import { RegistrationComponent } from './registration/registration.component';
import { TeacherPageComponent } from './teacher-page/teacher-page.component';
import { AddDisciplineComponent } from './add-discipline/add-discipline.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AddGradeComponent } from './add-grade/add-grade.component';
import { AssignGradeToStudentComponent } from './assign-grade-to-student/assign-grade-to-student.component';
import { ChiefTeacherPageComponent } from './chief-teacher-page/chief-teacher-page.component';
import { ViewAndApproveComponent } from './view-and-approve/view-and-approve.component';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    StudentPageComponentComponent,
    EnrolPageComponent,
    ViewCurriculumComponent,
    ChooseYearOfStudyComponent,
    SeeOptionalDisciplinesComponent,
    ViewGradesComponent,
    ChooseYearOfStudy2Component,
    RegistrationComponent,
    TeacherPageComponent,
    AddDisciplineComponent,
    AddGradeComponent,
    AssignGradeToStudentComponent,
    ChiefTeacherPageComponent,
    ViewAndApproveComponent
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
