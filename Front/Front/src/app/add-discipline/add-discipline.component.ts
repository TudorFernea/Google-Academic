import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { TeacherService } from '../services/teacher.service';
import { AuthService } from '../Servicies/auth.service';
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

  constructor(private teacherService: TeacherService, private authService: AuthService) { }
  yearOfStudy: YearOfStudy[]=[]

  ngOnInit(): void {
    this.getAllYearOfStudyByTeacher();
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

  getAllYearOfStudyByTeacher(){ //intri pe pagina, se apeleaza asta
    this.teacherService.getAllYearOfStudyByTeacher(this.authService.getUsername()).subscribe(
      allYear=>this.yearOfStudy=allYear
    )
  }

  addDiscipline(){
      this.teacherService.addDiscipline(
        this.addDisciplineForm.controls["name"].value,
        Number(this.addDisciplineForm.controls["credits"].value),
        this.addDisciplineForm.controls["curriculum"].value,
        this.authService.getUsername(),
        this.yearOfStudyId
      ).subscribe(
        ()=>alert("Optional added successfully")
      );
  }

}
