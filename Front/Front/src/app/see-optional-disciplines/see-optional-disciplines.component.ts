import { Component, OnInit } from '@angular/core';
import {CdkDragDrop, moveItemInArray} from '@angular/cdk/drag-drop';
import { Curriculum, Disciplines } from '../models/curriculum';
@Component({
  selector: 'app-see-optional-disciplines',
  templateUrl: './see-optional-disciplines.component.html',
  styleUrls: ['./see-optional-disciplines.component.css']
})
export class SeeOptionalDisciplinesComponent implements OnInit {
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
  constructor() {this.seeOptionalDisciplines(); }

  ngOnInit(): void {
  }
  seeOptionalDisciplines(){
    var disciplinesC=this.curriculum.disciplines;
    for(var i=0;i<disciplinesC.length;i++)
    if(disciplinesC[i].optional==true){this.disciplines.push(disciplinesC[i])}

  }
  drop(event: CdkDragDrop<Disciplines[]>) {
    moveItemInArray(this.disciplines, event.previousIndex, event.currentIndex);
  }
  
  isDragDrop(object: any): object is CdkDragDrop<string[]> {
    return 'previousIndex' in object;
  }

}
