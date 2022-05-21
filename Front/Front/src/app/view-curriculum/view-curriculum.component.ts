import { Component, OnInit } from '@angular/core';
import { Curriculum , Disciplines} from '../models/curriculum';
@Component({
  selector: 'app-view-curriculum',
  templateUrl: './view-curriculum.component.html',
  styleUrls: ['./view-curriculum.component.css']
})
export class ViewCurriculumComponent implements OnInit {
  disciplines: Disciplines[]=[];
  curriculum: Curriculum = {
    id: 0,
    disciplines: [
      {
        id: 0,
        name: "asc",
        optional: false
      },
      {
        id: 1,
        name: "os",
        optional: true
      },
      {
        id: 2,
        name: "bd",
        optional: false
      },
      {
        id: 0,
        name: "asc",
        optional: false
      },
      {
        id: 1,
        name: "os2",
        optional: true
      },
      {
        id: 2,
        name: "bd",
        optional: false
      },
      {
        id: 0,
        name: "asc",
        optional: false
      },
      {
        id: 1,
        name: "os3",
        optional: true
      },
      {
        id: 2,
        name: "bd",
        optional: false
      }
    ],
    yearOfStudy: 3
  }
  ;
  currentId: number = 0;
  constructor() {this.seeMandatoryDisciplines(); }

  ngOnInit(): void {
  }
  seeMandatoryDisciplines(){
    var disciplinesC=this.curriculum.disciplines;
    for(var i=0;i<disciplinesC.length;i++)
    if(disciplinesC[i].optional==false){this.disciplines.push(disciplinesC[i])}

  }

}
