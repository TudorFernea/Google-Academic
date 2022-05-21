import { Component, OnInit } from '@angular/core';
import { Curriculum, Disciplines, YearOfStudy } from '../models/curriculum'
@Component({
  selector: 'app-enrol-page',
  templateUrl: './enrol-page.component.html',
  styleUrls: ['./enrol-page.component.css']
})
export class EnrolPageComponent implements OnInit {
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
  ];
  
  currentId: number = 0;
  constructor() { }

  ngOnInit(): void {
  }
  nextCurriculum(){
    console.log(this.currentId);
    this.currentId++;
    console.log(this.currentId);
  }
  previousCurriculum(){
    console.log(this.currentId);
    this.currentId--;
    console.log(this.currentId);
  }
  enrol(){
    
  }
    
  

}
