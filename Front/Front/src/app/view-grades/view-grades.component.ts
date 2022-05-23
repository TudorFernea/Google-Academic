import { Component, OnInit } from '@angular/core';
import { YearOfStudy, Disciplines , Grade} from '../models/curriculum';

@Component({
  selector: 'app-view-grades',
  templateUrl: './view-grades.component.html',
  styleUrls: ['./view-grades.component.css']
})
export class ViewGradesComponent implements OnInit {
  gradesForStudent: {disciplineName: string, disciplineGrade: Number}[]=[];
  gradeForDiscipline: Number[]=[];
  disciplines: Disciplines[]=[
    {
      id: 0,
      name: "asc",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: [{id:0, text:"facem "}]
    },
    {
      id: 1,
      name: "asc2",
      optional: false,
      credits: 7,
      teacherName: "Emilia2",
      curriculum: [{id:1, text:"facem2 "}]
    },
    {
      id: 2,
      name: "asc3",
      optional: false,
      credits: 7,
      teacherName: "Emilia3",
      curriculum: [{id:2, text:"facem3 "}]
    },
    {
      id: 3,
      name: "asc3",
      optional: false,
      credits: 7,
      teacherName: "Emilia3",
      curriculum: [{id:3, text:"facem3 "}]
    },
    {
      id: 4,
      name: "asc4",
      optional: true,
      credits: 2,
      teacherName: "Emilia4",
      curriculum: [{id:4, text:"facem4 "}]
    }

  ];
  yearOfStudy: YearOfStudy[]=[
    {
      id: 1,
      year:1,
      specializationName:" mate info 1"
    },
    {
      id: 2,
      year:2,
      specializationName:" slcnsdjbc"
    },
    

  ];
  grades: Grade[]=[
    {
      id: 1,
      studentId:1,
      disciplineId:1,
      value:10
    },
    {
      id: 2,
      studentId:1,
      disciplineId:1,
      value:9
    },
    {
      id: 3,
      studentId:1,
      disciplineId:2,
      value:2
    },
    {
      id: 3,
      studentId:1,
      disciplineId:3,
      value:10
    },


  ];
  currentId: number = 0;
  constructor() {
  }

  ngOnInit(): void {
    for(var i=0;i<this.disciplines.length;i++)
    {
    this.getGradesForDiscipline(this.disciplines[i].id);}
  }

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
  
  }

}
