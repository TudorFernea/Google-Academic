import { Component, OnInit } from '@angular/core';
import {  YearOfStudy, Disciplines} from '../models/curriculum';
@Component({
  selector: 'app-view-curriculum',
  templateUrl: './view-curriculum.component.html',
  styleUrls: ['./view-curriculum.component.css']
})
export class ViewCurriculumComponent implements OnInit {
  mandatoryDiscipline: Disciplines[]=[];
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
      specializationName:" mate info 2"
    },
    {
      id: 3,
      year:3,
      specializationName:" mate info 3"
    },
    {
      id: 3,
      year:3,
      specializationName:" mate info 3"
    }
  ]
  ;
  currentId: number = 0;
  constructor() {this.seeMandatoryDisciplines(); }
 

  ngOnInit(): void {
  }
  seeMandatoryDisciplines(){
   
    for(var i=0;i<this.disciplines.length;i++)
    if(this.disciplines[i].optional==false){this.mandatoryDiscipline.push(this.disciplines[i])}

  }

}
