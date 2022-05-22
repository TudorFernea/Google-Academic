import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { TeacherService } from '../services/teacher.service';
import { AuthService } from '../Servicies/auth.service';

@Component({
  selector: 'app-add-discipline',
  templateUrl: './add-discipline.component.html',
  styleUrls: ['./add-discipline.component.css']
})
export class AddDisciplineComponent implements OnInit {
  
  addDisciplineForm= new FormGroup({
    name: new FormControl(''),
    credits : new FormControl(''),
    curriculum: new FormControl(''),
  })

  constructor(private teacherService: TeacherService, private authService: AuthService) { }

  ngOnInit(): void {
  }

  addDiscipline(){
      this.teacherService.addDiscipline(
        this.addDisciplineForm.controls["name"].value,
        Number(this.addDisciplineForm.controls["credits"].value),
        this.addDisciplineForm.controls["curriculum"].value,
        this.authService.getUsername()
      ).subscribe(
        ()=>alert("Optional added successfully")
      );
  }

}
