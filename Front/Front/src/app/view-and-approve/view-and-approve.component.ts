import { Component, OnInit, Optional } from '@angular/core';
import { ApprovedOptional, Disciplines, Grade, OptionalApproval, YearOfStudy } from '../models/curriculum';
import { TeacherService } from '../services/teacher.service';
import { AuthService } from '../Servicies/auth.service';

@Component({
  selector: 'app-view-and-approve',
  templateUrl: './view-and-approve.component.html',
  styleUrls: ['./view-and-approve.component.css']
})
export class ViewAndApproveComponent implements OnInit {
  submitButtonDisabled: boolean = false;
  approveButton: boolean[]=[false,false,false,false];
  disapproveButon: boolean[]=[false,false,false,false];

  listWithDiscipline: {discipline: Disciplines, approved: boolean, noStudents: number, aproveButton: boolean, disapproveButton:boolean, submitButton:boolean}[]=[
    {discipline: {
      id: 0,
      name: "asc",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: {id:0, text:"facem "}
    },
    approved: false,
    noStudents: 0,
    aproveButton: false,
    disapproveButton: false,
    submitButton: false
    },
    {discipline:{
      id: 1,
      name: "asc2",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: {id:0, text:"facem "}
    },
    approved: false,
    noStudents: 0,
    aproveButton: false,
    disapproveButton:false,
    submitButton: false},
    {discipline:{
      id: 110,
      name: "asc3",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: {id:0, text:"facem "}
    },
    approved: false,
    noStudents: 0,
    aproveButton: false,
    disapproveButton: false,
    submitButton: false},
    {discipline:{
      id: 10,
      name: "asc4",
      optional: true,
      credits: 7,
      teacherName: "Emilia",
      curriculum: {id:0, text:"facem "}
    },
    approved: false,
    noStudents: 0,
    aproveButton: false,
    disapproveButton: false,
    submitButton: false}


  ]
  optinalDisciplines: Disciplines[]=[


  approvedOptionals: ApprovedOptional[]=[]


  constructor(private teacherService: TeacherService, private authService: AuthService) { }

  ngOnInit(): void {
    this.teacherService.getAllOptionalByFaculty(this.authService.getUsername()).subscribe(
      optionals=>{
        this.optinalDisciplines=optionals,
        this.setList()
      }

    )
  }

  setList(){
    console.log(this.optinalDisciplines);
    for(let i=0;i<this.optinalDisciplines.length; i++)
    {
        let discipline:Disciplines =  this.optinalDisciplines[i];
        let approved = false;
        let noStudents = 0;
        let aproveButton = false;
        let disapproveButton = false;
        let approval:OptionalApproval = {discipline,approved,noStudents,aproveButton,disapproveButton};
        this.listWithDiscipline.push(approval);
    }
    console.log(this.listWithDiscipline);
  }

  setApprove(disciplineId: number){
    for(var i=0;i<this.listWithDiscipline.length;i++)
    if(this.listWithDiscipline[i].discipline.id===disciplineId)
    {this.listWithDiscipline[i].approved=true;
      this.listWithDiscipline[i].aproveButton=true;
       this.listWithDiscipline[i].disapproveButton=false;}


  }
  setDisapprove(disciplineId: number){
    for(var i=0;i<this.listWithDiscipline.length;i++)
    if(this.listWithDiscipline[i].discipline.id===disciplineId)
    {this.listWithDiscipline[i].approved=false;
      this.listWithDiscipline[i].noStudents=0;
      this.listWithDiscipline[i].aproveButton=false;
      this.listWithDiscipline[i].disapproveButton=true;
      this.listWithDiscipline[i].submitButton=true;
    }

  }

  assignOptionals(){
    for(var i=0;i<this.listWithDiscipline.length;i++)
      if(this.listWithDiscipline[i].approved!=false)
      {
        let id = this.listWithDiscipline[i].discipline.id;
        let noStudents = this.listWithDiscipline[i].noStudents;
        let optional:ApprovedOptional={id, noStudents};
        this.approvedOptionals.push(optional);
      }
    this.teacherService.assignOptionals(this.approvedOptionals).subscribe(
      ()=>alert("Assigned optionals")
    )
  }

  myFunction() {
    this.submitButtonDisabled = true;
    this.assignOptionals()
  }
  setNoStudents(disciplineid: number, noStud: number){
    for(var i=0;i<this.listWithDiscipline.length;i++)
    {
      if(this.listWithDiscipline[i].discipline.id===disciplineid)
      {
        this.listWithDiscipline[i].noStudents=noStud;
        this.listWithDiscipline[i].submitButton = true;
        console.log(noStud);
      }
    }

  }


}
