import { Component, OnInit } from '@angular/core';
import { Disciplines, Teacher, YearOfStudy } from '../models/curriculum';

@Component({
  selector: 'app-view-discipline-given-by-teacher',
  templateUrl: './view-discipline-given-by-teacher.component.html',
  styleUrls: ['./view-discipline-given-by-teacher.component.css']
})
export class ViewDisciplineGivenByTeacherComponent implements OnInit {
  yearOfStudyId!: number;
  teacherId!:number;
  disciplines: Disciplines[]=[
    {
      id: 0,
      name: "asc",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: {id:0, text:"facem "}
    },
    {
      id: 1,
      name: "asc2",
      optional: false,
      credits: 7,
      teacherName: "Emilia2",
      curriculum: {id:1, text:"facem2 "}
    },
    {
      id: 2,
      name: "asc3",
      optional: false,
      credits: 7,
      teacherName: "Emilia3",
      curriculum: {id:2, text:"facem3 "}
    },
    {
      id: 3,
      name: "asc3",
      optional: false,
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
    {
      id: 2,
      year:2,
      specializationName:" slcnsdjbc"
    },]
    teachers: Teacher[]=[
     { id:1,
      name: "iulia"},
      {
        id:2,
      name: "iuliaaa"
      },
      {
        id:3,
      name: "iuliaaaaaa"
      },
      {
        id:4,
      name: "sharra"
      },
      {
        id:5,
      name: "tudor"
      },
      {
        id:5,
      name: "luana"
      }
    ];

  constructor() { }

  ngOnInit(): void {
  }
  public changeYearOfStudy(e: any){
    this.yearOfStudyId=e.target.value;
    if (this.yearOfStudyId===undefined){
      // this.studentByDiscipline=[];
      // this.page=0;
    }
    // else{
    //   this.page=0;
    //     this.getStudentGradesByGroup(this.group,this.page);
    //     this.getnumberOfStudents(this.group);
    // }
  }
  
  public changeTeacherName(e: any){
    this.yearOfStudyId=e.target.value;
    if (this.yearOfStudyId===undefined){
      // this.studentByDiscipline=[];
      // this.page=0;
    }
    // else{
    //   this.page=0;
    //     this.getStudentGradesByGroup(this.group,this.page);
    //     this.getnumberOfStudents(this.group);
    // }
  }

}
