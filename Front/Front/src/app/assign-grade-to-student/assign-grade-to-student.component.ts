import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';
import { switchMap } from 'rxjs';
import { Disciplines, Student, YearOfStudy } from '../models/curriculum';
import { TeacherService } from '../services/teacher.service';
import { AuthService } from '../Servicies/auth.service';

@Component({
  selector: 'app-assign-grade-to-student',
  templateUrl: './assign-grade-to-student.component.html',
  styleUrls: ['./assign-grade-to-student.component.css']
})
export class AssignGradeToStudentComponent implements OnInit {

  disciplineName: string="";
  disciplines: Disciplines[]=[];
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
  students: Student[]=[];
  disciplineId!: number;
  insertGradeForm= new FormGroup({
    grade: new FormControl(''),
  })
  currentId: number = 0;
  constructor(private teacherService: TeacherService,private authService:AuthService, private route:ActivatedRoute) { }

  ngOnInit(): void {
    //document.getElementById("grade")?.innerHTML;
    this.route.params.subscribe(
      params=>this.disciplineId=params['id']
    )
    this.teacherService.getAllStudentByDiscipline(this.disciplineId).subscribe(
      student=>this.students=student
    )
  }

  addGrade(student: Student){
    //console.log("aaaaaa");
    this.teacherService.addGrade(document.getElementById("grade")?.innerHTML, this.disciplineId, student.id).subscribe(
      ()=>alert("Grade added")
    )
  }

}
