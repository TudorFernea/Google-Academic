import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChooseYearOfStudyComponent } from './choose-year-of-study/choose-year-of-study.component';
import { EnrolPageComponent } from './enrol-page/enrol-page.component';

import { LoginComponent } from './login/login.component';
import { SeeOptionalDisciplinesComponent } from './see-optional-disciplines/see-optional-disciplines.component';
import { StudentPageComponentComponent } from './student-page/student-page-component.component';
import { ViewCurriculumComponent } from './view-curriculum/view-curriculum.component';
import { ViewGradesComponent } from './view-grades/view-grades.component';
import {ChooseYearOfStudy2Component} from './choose-year-of-study2/choose-year-of-study2.component'
import { RegistrationComponent } from './registration/registration.component';
import { TeacherPageComponent } from './teacher-page/teacher-page.component';
import { AddDisciplineComponent } from './add-discipline/add-discipline.component';
import { AddGradeComponent } from './add-grade/add-grade.component';
import { AssignGradeToStudentComponent } from './assign-grade-to-student/assign-grade-to-student.component';
import { ChiefTeacherPageComponent } from './chief-teacher-page/chief-teacher-page.component';
import { ViewAndApproveComponent } from './view-and-approve/view-and-approve.component';

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'studentPage', component: StudentPageComponentComponent },
  {path: 'enrolPage', component: EnrolPageComponent },
  {path: 'viewCurriculumPage', component: ViewCurriculumComponent},
  {path: 'chooseYearOfStudyPage', component: ChooseYearOfStudyComponent},
  {path: 'seeOptionalDisciplinesPage', component: SeeOptionalDisciplinesComponent},
  {path: 'viewGradesPage', component: ViewGradesComponent},
  {path: 'chooseYearOfStudy2', component: ChooseYearOfStudy2Component},
  {path: 'registration', component: RegistrationComponent},
  {path: 'teacherPage', component: TeacherPageComponent},
  {path: 'addDiscipline', component: AddDisciplineComponent},
  {path: 'addGrade', component: AddGradeComponent},
  {path: 'assignGradeToStudent', component: AssignGradeToStudentComponent},
  {path: 'chiefTeacherPage', component: ChiefTeacherPageComponent},
  {path: 'viewAndAprove', component: ViewAndApproveComponent}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
