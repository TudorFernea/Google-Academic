import { Component, OnInit } from '@angular/core';
import { YearOfStudy, Disciplines , Grade, GradeDiscipline} from '../models/curriculum';
import { EnrolService } from '../services/enrol.service';
import { AuthService } from '../Servicies/auth.service';

@Component({
  selector: 'app-view-grades',
  templateUrl: './view-grades.component.html',
  styleUrls: ['./view-grades.component.css']
})
export class ViewGradesComponent implements OnInit {
  gradesForStudent: GradeDiscipline[]=[];
  currentYear!:number;
  yearOfStudy: YearOfStudy[]=[];
  constructor(private enrolService: EnrolService, private authService: AuthService) {}

  getAllYearOfStudyByStudent(){ //intri pe pagina, se apeleaza asta
    this.enrolService.getAllYearOfStudyByStudent(this.authService.getUsername()).subscribe(
      allYear=>this.yearOfStudy=allYear
    )
  }

  ngOnInit(): void {
    this.getAllYearOfStudyByStudent()
  }

  getCurrentYear(num:number){
    this.currentYear = num-1;
  }

  getGrades(){
    this.enrolService.getGradesByYearOfStudy(this.yearOfStudy[this.currentYear],this.authService.getUsername()).subscribe(
      allGrades=>this.gradesForStudent=allGrades
    )
  }


  /*
  getNameWithId(id: number): string{
    for(var i=0;i<this.disciplines.length;i++)
    if(this.disciplines[i].id===id) return this.disciplines[i].name;
    return "";
  }
  getGradesForDiscipline(disciplineId: number){
   
    for(var i=0;i<this.grades.length;i++)
    if(this.grades[i].disciplineId===disciplineId) {var name: string=""; name=this.getNameWithId(this.grades[i].disciplineId);
      var obj = {disciplineName: name, disciplineGrade: this.grades[i].value}
      this.gradesForStudent.push(obj)
    console.log(obj);}
  
  }*/

}
