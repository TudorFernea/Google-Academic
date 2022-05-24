import { Component, OnInit } from '@angular/core';
import { Student } from '../models/curriculum';

@Component({
  selector: 'app-print-list-students',
  templateUrl: './print-list-students.component.html',
  styleUrls: ['./print-list-students.component.css']
})
export class PrintListStudentsComponent implements OnInit {
  groups: String[]=["921","922","923"];
  group!: string;
  studentsResults: {student: Student, result: number}[]=[
    {
      student: {id: 1, firstName: "Iulia", lastName:"Farcas", group:"921"},
      result: 7
    },
    {
      student: {id: 2, firstName: "Sharra", lastName:"Dalia", group:"921"},
      result: 9
    },
    {
      student: {id: 3, firstName: "Tudor", lastName:"Fernea", group:"921"},
      result: 9
    },
    {
      student: {id: 4, firstName: "Luana", lastName:"Duma", group:"921"},
      result: 10
    },


  ]
  constructor() { }

  ngOnInit(): void {
  }
  public changeGroup(e: any){
    this.group=e.target.value;
    if (this.group===undefined){
      // this.studentByDiscipline=[];
      // this.page=0;
    }
    // else{
    //   this.page=0;
    //     this.getStudentGradesByGroup(this.group,this.page);
    //     this.getnumberOfStudents(this.group);
    // }
  }
  seeStudentsWithResultsBetween(start: number, end: number){
      
  }
  

}
