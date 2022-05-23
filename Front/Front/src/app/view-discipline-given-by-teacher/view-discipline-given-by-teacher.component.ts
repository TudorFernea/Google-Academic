import { Component, OnInit } from '@angular/core';
import { Disciplines, Teacher, YearOfStudy } from '../models/curriculum';
import { TeacherService } from '../services/teacher.service';
import { AuthService } from '../Servicies/auth.service';

@Component({
  selector: 'app-view-discipline-given-by-teacher',
  templateUrl: './view-discipline-given-by-teacher.component.html',
  styleUrls: ['./view-discipline-given-by-teacher.component.css']
})
export class ViewDisciplineGivenByTeacherComponent implements OnInit {
  yearOfStudyId!: number;
  teacherId!:number;
  disciplines: Disciplines[]=[];
  yearOfStudy: YearOfStudy[]=[];
    teachers: Teacher[]=[];

  constructor(private teacherService: TeacherService, private authService:AuthService) { }

  ngOnInit(): void {
    this.teacherService.getAllYearOfStudyByTeacher(this.authService.getUsername()).subscribe(
      years=>{
        this.yearOfStudy=years
      this.teacherService.getAllTeacherByFaculty(this.authService.getUsername()).subscribe(
        teacherss=>this.teachers=teacherss
      )
      }
    )
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
    this.teacherId=e.target.value;
    if (this.teacherId===undefined){
      // this.studentByDiscipline=[];
      // this.page=0;
    }
    // else{
    //   this.page=0;
    //     this.getStudentGradesByGroup(this.group,this.page);
    //     this.getnumberOfStudents(this.group);
    // }
  }

  public getDisciplines(){
    this.teacherService.getDisciplinesByTeacherAndYear(this.yearOfStudyId, this.teacherId).subscribe(
      discipline=>this.disciplines=discipline
    )
  }

}
