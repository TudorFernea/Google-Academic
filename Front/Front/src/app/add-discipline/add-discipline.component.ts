import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

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

  constructor() { }

  ngOnInit(): void {
  }

}
