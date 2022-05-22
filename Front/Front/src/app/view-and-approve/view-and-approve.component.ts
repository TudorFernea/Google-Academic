import { Component, OnInit } from '@angular/core';
import { Disciplines, Grade, YearOfStudy } from '../models/curriculum';

@Component({
  selector: 'app-view-and-approve',
  templateUrl: './view-and-approve.component.html',
  styleUrls: ['./view-and-approve.component.css']
})
export class ViewAndApproveComponent implements OnInit {
  listWithDiscipline: {discipline: Disciplines, approved: boolean, noStudents: number}[]=[
    {discipline: {
      id: 0,
      name: "asc",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: [{id:0, text:"facem "}]
    },
    approved: false,
    noStudents: 0},
    {discipline:{
      id: 0,
      name: "asc2",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: [{id:0, text:"facem "}]
    },
    approved: false,
    noStudents: 0},
    {discipline:{
      id: 0,
      name: "asc3",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: [{id:0, text:"facem "}]
    },
    approved: false,
    noStudents: 0},
    {discipline:{
      id: 0,
      name: "asc4",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: [{id:0, text:"facem "}]
    },
    approved: false,
    noStudents: 0}
   
  
  ]
  optinalDisciplines: Disciplines[]=[

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
      optional: true,
      credits: 7,
      teacherName: "Emilia2",
      curriculum: [{id:1, text:"facem2 "}]
    },
    {
      id: 2,
      name: "asc3",
      optional: true,
      credits: 7,
      teacherName: "Emilia3",
      curriculum: [{id:2, text:"facem3 "}]
    },
    {
      id: 3,
      name: "asc3",
      optional: true,
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
  constructor() { }

  ngOnInit(): void {
  }
  setApprove(disciplineId: number){
    for(var i=0;i<this.listWithDiscipline.length;i++)
    if(this.listWithDiscipline[i].discipline.id===disciplineId) this.listWithDiscipline[i].approved=true;

   
  }
  setDisapprove(disciplineId: number){
    for(var i=0;i<this.listWithDiscipline.length;i++)
    if(this.listWithDiscipline[i].discipline.id===disciplineId) {this.listWithDiscipline[i].approved=false; 
      this.listWithDiscipline[i].noStudents=0;}

  }
 
  

}
