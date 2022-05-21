import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChooseYearOfStudyComponent } from './choose-year-of-study/choose-year-of-study.component';
import { EnrolPageComponent } from './enrol-page/enrol-page.component';

import { LoginComponent } from './login/login.component';
import { SeeOptionalDisciplinesComponent } from './see-optional-disciplines/see-optional-disciplines.component';
import { StudentPageComponentComponent } from './student-page/student-page-component.component';
import { ViewCurriculumComponent } from './view-curriculum/view-curriculum.component';
import { ViewGradesComponent } from './view-grades/view-grades.component';

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'studentPage', component: StudentPageComponentComponent },
  {path: 'enrolPage', component: EnrolPageComponent },
  {path: 'viewCurriculumPage', component: ViewCurriculumComponent},
  {path: 'chooseYearOfStudyPage', component: ChooseYearOfStudyComponent},
  {path: 'seeOptionalDisciplinesPage', component: SeeOptionalDisciplinesComponent},
  {path: 'viewGradesPage', component: ViewGradesComponent}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
