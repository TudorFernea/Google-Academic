import { Component, OnInit } from '@angular/core';
import {  YearOfStudy, Disciplines} from '../models/curriculum';
import { EnrolService } from '../services/enrol.service';
import { AuthService } from '../Servicies/auth.service';
import {CdkDragDrop, moveItemInArray} from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-view-curriculum',
  templateUrl: './view-curriculum.component.html',
  styleUrls: ['./view-curriculum.component.css']
})
export class ViewCurriculumComponent implements OnInit {
  //mandatoryDiscipline: Disciplines[]=[];

  disciplines: Disciplines[]=[];
  yearOfStudy: YearOfStudy[]=[];
  //choices: Choice[]=[];
  currentId: number = 0;
  optionalDisciplines: Disciplines[]=[];
  constructor(private enrolService: EnrolService,private authService: AuthService) {}
 
  ngOnInit(): void {
    this.getAllYearOfStudyByStudent();
  }

  getAllYearOfStudyByStudent(){ //intri pe pagina, se apeleaza asta
    this.enrolService.getAllYearOfStudyByStudent(this.authService.getUsername()).subscribe(
      allYear=>this.yearOfStudy=allYear
    )
  }

  getDisciplinesByYearOfStudy(yearnum: number){ //in functie de ce ai primit mai sus, apesi pe butonul de year1 sau year2 si se apeleaza asta ca sa populezi o lista cu discipline si curriculum
    this.enrolService.getDisciplineByYearOfStudy(this.yearOfStudy[yearnum-1]).subscribe(
      allDiscipline=>this.disciplines=allDiscipline
    );
  }
  
  getOptionalDisciplinesByYearOfStudy(yearnum: number){ //in functie de ce ai primit mai sus, apesi pe butonul de year1 sau year2 si se apeleaza asta ca sa populezi o lista cu discipline si curriculum
    this.enrolService.getOptionalDisciplineByYearOfStudy(this.yearOfStudy[yearnum-1]).subscribe(
      allDiscipline=>this.optionalDisciplines=allDiscipline
    );
  }

  /*
  seeMandatoryDisciplines(){
   
    for(var i=0;i<this.disciplines.length;i++)
    if(this.disciplines[i].optional==false){this.mandatoryDiscipline.push(this.disciplines[i])}

  }*/

  updateChoices(){
    this.enrolService.updateChoices(this.authService.getUsername(), this.optionalDisciplines).subscribe(
      ()=>alert("Updated")
    )
  }

  drop(event: CdkDragDrop<Disciplines[]>) {
    moveItemInArray(this.optionalDisciplines, event.previousIndex, event.currentIndex);
    this.updateChoices();
  }
  
  isDragDrop(object: any): object is CdkDragDrop<string[]> {
    return 'previousIndex' in object;
  }
}
