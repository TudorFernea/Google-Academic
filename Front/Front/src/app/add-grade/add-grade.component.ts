import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Disciplines, Student, YearOfStudy } from '../models/curriculum';
import { TeacherService } from '../services/teacher.service';
import { AuthService } from '../Servicies/auth.service';

@Component({
  selector: 'app-add-grade',
  templateUrl: './add-grade.component.html',
  styleUrls: ['./add-grade.component.css']
})
export class AddGradeComponent implements OnInit {
  nameOfDisciplines: string[]=[];
  discipline!: number;
  studentByDiscipline: Student[]=[];
  page: number=0;
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
  
  currentId: number = 0;
  constructor(private teacherService: TeacherService,private authService:AuthService, private router:Router) { }

  ngOnInit(): void {
    this.getAllDisciplineByTeacher();
  }

  goToAssignGrade(){
    this.router.navigate(['/assignGradeToStudent',this.discipline]);
  }

  public changeDiscipline(e: any){
    this.discipline=e.target.value;
    if (this.discipline===undefined){
      this.studentByDiscipline=[];
      this.page=0;
    }
    // else{
    //   this.page=0;
    //     this.getStudentGradesByGroup(this.group,this.page);
    //     this.getnumberOfStudents(this.group);
    // }
  }

  getDisciplineNames(){
    for(let i=0; i<this.disciplines.length; i++)
      this.nameOfDisciplines[i] = this.disciplines[i].name;
  }

  getAllDisciplineByTeacher(){
    this.teacherService.getAllDisciplineByTeacher(this.authService.getUsername()).subscribe(
      allDiscipline=>{
        this.disciplines=allDiscipline,
        this.getDisciplineNames()
      }
    )
  }
}
