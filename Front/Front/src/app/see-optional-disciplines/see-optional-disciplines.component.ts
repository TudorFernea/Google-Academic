import { Component, OnInit } from '@angular/core';
import {CdkDragDrop, moveItemInArray} from '@angular/cdk/drag-drop';
import { YearOfStudy, Disciplines } from '../models/curriculum';
@Component({
  selector: 'app-see-optional-disciplines',
  templateUrl: './see-optional-disciplines.component.html',
  styleUrls: ['./see-optional-disciplines.component.css']
})
export class SeeOptionalDisciplinesComponent implements OnInit {
  optionalDisciplines: Disciplines[]=[];
  disciplines: Disciplines[]=[
    {
      id: 0,
      name: "asc",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: {id:0, text:"facem "}
    },
    {
      id: 1,
      name: "asc2",
      optional: false,
      credits: 7,
      teacherName: "Emilia2",
      curriculum: {id:1, text:"facem2 "}
    },
    {
      id: 2,
      name: "asc3",
      optional: false,
      credits: 7,
      teacherName: "Emilia3",
      curriculum: {id:2, text:"facem3 "}
    },
    {
      id: 3,
      name: "asc3",
      optional: false,
      credits: 7,
      teacherName: "Emilia3",
      curriculum: {id:3, text:"facem3 "}
    },
    {
      id: 4,
      name: "asc4",
      optional: true,
      credits: 2,
      teacherName: "Emilia4",
      curriculum: {id:4, text:"facem4 "}
    }

  ];
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
  constructor() {this.seeOptionalDisciplines(); }

  ngOnInit(): void {
  }
  seeOptionalDisciplines(){
   
    for(var i=0;i<this.disciplines.length;i++)
    if(this.disciplines[i].optional==true){this.optionalDisciplines.push(this.disciplines[i])}

  }
  drop(event: CdkDragDrop<Disciplines[]>) {
    moveItemInArray(this.disciplines, event.previousIndex, event.currentIndex);
  }
  
  isDragDrop(object: any): object is CdkDragDrop<string[]> {
    return 'previousIndex' in object;
  }

}
