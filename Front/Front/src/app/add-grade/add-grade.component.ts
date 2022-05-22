import { Component, OnInit } from '@angular/core';
import { Disciplines, Student, YearOfStudy } from '../models/curriculum';

@Component({
  selector: 'app-add-grade',
  templateUrl: './add-grade.component.html',
  styleUrls: ['./add-grade.component.css']
})
export class AddGradeComponent implements OnInit {
  nameOfDisciplines: string[]=["asc", "fp", "db","geo","cs","iss"];
  disciplineName: string="";
  studentByDiscipline: Student[]=[];
  page: number=0;
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
  public changeDiscipline(e: any){
    this.disciplineName=e.target.value;
    if (this.disciplineName===""){
      this.studentByDiscipline=[];
      this.page=0;
  
    }
    // else{
    //   this.page=0;
    //     this.getStudentGradesByGroup(this.group,this.page);
    //     this.getnumberOfStudents(this.group);
    // }
  }
}
