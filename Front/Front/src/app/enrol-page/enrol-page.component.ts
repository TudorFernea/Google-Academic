import { Component, OnInit } from '@angular/core';
import { delay } from 'rxjs';
import { Curriculum, Disciplines, YearOfStudy } from '../models/curriculum'
import { EnrolService } from '../services/enrol.service';
import { JwtHelperService } from '@auth0/angular-jwt';
import { AuthService } from '../Servicies/auth.service';

@Component({
  selector: 'app-enrol-page',
  templateUrl: './enrol-page.component.html',
  styleUrls: ['./enrol-page.component.css']
})
export class EnrolPageComponent implements OnInit {
  disciplines: Disciplines[]=[];
  yearOfStudy: YearOfStudy[]=[];
  
  currentId: number = 0;
  constructor(private enrolService: EnrolService, private authService: AuthService) {
   }

  ngOnInit(): void {
    this.getAllYearOfStudy();
    //if(this.yearOfStudy.length != 0)
     // this.getDisciplinesByYearOfStudy();
  }
  nextCurriculum(){
    console.log(this.currentId);
    this.currentId++;
    console.log(this.currentId);
    this.getDisciplinesByYearOfStudy();
  }
  previousCurriculum(){
    console.log(this.currentId);
    this.currentId--;
    console.log(this.currentId);
    this.getDisciplinesByYearOfStudy();
  }
  getAllYearOfStudy(){
    this.enrolService.getAllYearOfStudy().subscribe(
      allYear=>{this.yearOfStudy=allYear,
      this.getDisciplinesByYearOfStudy()
      }
      )
  }
  
  getDisciplinesByYearOfStudy(){
    this.enrolService.getDisciplineByYearOfStudy(this.yearOfStudy[this.currentId]).subscribe(
      allDiscipline=>this.disciplines=allDiscipline
    );
  }

  enrol(){
   this.enrolService.enrol(this.authService.getUsername(),this.yearOfStudy[this.currentId]).subscribe(
     ()=>alert("Student enrolled")
   );
  }
  
    
  

}
