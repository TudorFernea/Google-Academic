import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Disciplines, Student, YearOfStudy } from '../models/curriculum';

@Component({
  selector: 'app-assign-grade-to-student',
  templateUrl: './assign-grade-to-student.component.html',
  styleUrls: ['./assign-grade-to-student.component.css']
})
export class AssignGradeToStudentComponent implements OnInit {
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
  students: Student[]=[
    {id:1,
    nume:"Farcas",
    prenume:"Iulia"},
    {id:2,
      nume:"Farcas",
      prenume:"yu"},
      {id:3,
        nume:"Dalia",
        prenume:"Sharra"},
        {id:4,
          nume:"Fernea",
          prenume:"Sharra"},


  ];
  insertGradeForm= new FormGroup({
    grade: new FormControl(''),


  })
  currentId: number = 0;
  constructor() { }

  ngOnInit(): void {
  }

}
