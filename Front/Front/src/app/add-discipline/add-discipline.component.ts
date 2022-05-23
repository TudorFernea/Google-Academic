import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { YearOfStudy } from '../models/curriculum';

@Component({
  selector: 'app-add-discipline',
  templateUrl: './add-discipline.component.html',
  styleUrls: ['./add-discipline.component.css']
})
export class AddDisciplineComponent implements OnInit {
  yearOfStudyId!: number;
  addDisciplineForm= new FormGroup({
    name: new FormControl(''),
    credits : new FormControl(''),
    curriculum: new FormControl(''),


  })
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

}
