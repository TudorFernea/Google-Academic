import { Component, OnInit } from '@angular/core';
import { Disciplines, Grade, YearOfStudy } from '../models/curriculum';

@Component({
  selector: 'app-view-and-approve',
  templateUrl: './view-and-approve.component.html',
  styleUrls: ['./view-and-approve.component.css']
})
export class ViewAndApproveComponent implements OnInit {
  submitButtonDisabled: boolean = false;
  approveButton: boolean[]=[false,false,false,false];
  disapproveButon: boolean[]=[false,false,false,false];
  listWithDiscipline: {discipline: Disciplines, approved: boolean, noStudents: number, aproveButton: boolean, disapproveButton:boolean, submitButton:boolean}[]=[
    {discipline: {
      id: 0,
      name: "asc",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: {id:0, text:"facem "}
    },
    approved: false,
    noStudents: 0,
    aproveButton: false,
    disapproveButton: false,
    submitButton: false
    },
    {discipline:{
      id: 1,
      name: "asc2",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: {id:0, text:"facem "}
    },
    approved: false,
    noStudents: 0,
    aproveButton: false,
    disapproveButton:false,
    submitButton: false},
    {discipline:{
      id: 110,
      name: "asc3",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: {id:0, text:"facem "}
    },
    approved: false,
    noStudents: 0,
    aproveButton: false,
    disapproveButton: false,
    submitButton: false},
    {discipline:{
      id: 10,
      name: "asc4",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: {id:0, text:"facem "}
    },
    approved: false,
    noStudents: 0,
    aproveButton: false,
    disapproveButton: false,
    submitButton: false}
   
  
  ]
  optinalDisciplines: Disciplines[]=[

    {
      id: 11110,
      name: "asc",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: {id:0, text:"facem "}
    },
    {
      id: 11111,
      name: "asc2",
      optional: true,
      credits: 7,
      teacherName: "Emilia2",
      curriculum: {id:1, text:"facem2 "}
    },
    {
      id: 2,
      name: "asc3",
      optional: true,
      credits: 7,
      teacherName: "Emilia3",
      curriculum: {id:2, text:"facem3 "}
    },
    {
      id: 3,
      name: "asc3",
      optional: true,
      credits: 7,
      teacherName: "Emilia3",
      curriculum: {id:3, text:"facem3 "}
    },
    {
      id: 4,
      name: "asc4",
      optional: true,
      credits: 2,
      teacherName: "Emilia4",
      curriculum: {id:4, text:"facem4 "}
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
    if(this.listWithDiscipline[i].discipline.id===disciplineId) 
    {this.listWithDiscipline[i].approved=true; 
      this.listWithDiscipline[i].aproveButton=true;
       this.listWithDiscipline[i].disapproveButton=false;}

   
  }
  setDisapprove(disciplineId: number){
    for(var i=0;i<this.listWithDiscipline.length;i++)
    if(this.listWithDiscipline[i].discipline.id===disciplineId) 
    {this.listWithDiscipline[i].approved=false; 
      this.listWithDiscipline[i].noStudents=0; 
      this.listWithDiscipline[i].aproveButton=false;
      this.listWithDiscipline[i].disapproveButton=true;
      this.listWithDiscipline[i].submitButton=true;
    }

  }
 
  myFunction() {
    this.submitButtonDisabled = true;
  }
  setNoStudents(disciplineid: number, noStud: number){
    for(var i=0;i<this.listWithDiscipline.length;i++)
    {
      if(this.listWithDiscipline[i].discipline.id===disciplineid) 
      {
        this.listWithDiscipline[i].noStudents=noStud;
        this.listWithDiscipline[i].submitButton = true;
        console.log(noStud);
      }
    }

  }
  

}
