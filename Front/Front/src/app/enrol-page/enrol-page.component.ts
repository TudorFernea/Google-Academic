import { Component, OnInit } from '@angular/core';
import { Curriculum, Disciplines } from '../models/curriculum'
@Component({
  selector: 'app-enrol-page',
  templateUrl: './enrol-page.component.html',
  styleUrls: ['./enrol-page.component.css']
})
export class EnrolPageComponent implements OnInit {

  curriculums: Curriculum[] = [{
    id: 0,
    disciplines: [
      {
        id: 0,
        name: "asc",
        optional: false
      },
      {
        id: 1,
        name: "os",
        optional: true
      },
      {
        id: 2,
        name: "bd",
        optional: false
      },
      {
        id: 0,
        name: "asc",
        optional: false
      },
      {
        id: 1,
        name: "os",
        optional: true
      },
      {
        id: 2,
        name: "bd",
        optional: false
      },
      {
        id: 0,
        name: "asc",
        optional: false
      },
      {
        id: 1,
        name: "os",
        optional: true
      },
      {
        id: 2,
        name: "bd",
        optional: false
      }
    ],
    yearOfStudy: 3
  },
  {
    id: 1,
    disciplines: [
      {
        id: 0,
        name: "ssc",
        optional: true
      },
      {
        id: 1,
        name: "ss",
        optional: false
      },
      {
        id: 2,
        name: "sd",
        optional: true
      }
    ],
    yearOfStudy: 2
  },
  {
    id: 2,
    disciplines: [
      {
        id: 0,
        name: "sd",
        optional: true
      },
      {
        id: 1,
        name: "aaa",
        optional: false
      },
      {
        id: 2,
        name: "aa",
        optional: true
      }
    ],
    yearOfStudy: 2
  }];;
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
