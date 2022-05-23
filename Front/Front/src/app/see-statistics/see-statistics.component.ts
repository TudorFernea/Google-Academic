import { Component, OnInit } from '@angular/core';
import { Result } from '../models/curriculum';

@Component({
  selector: 'app-see-statistics',
  templateUrl: './see-statistics.component.html',
  styleUrls: ['./see-statistics.component.css']
})
export class SeeStatisticsComponent implements OnInit {
  bestResult: Result={disciplineName:"Desen", averageGrade: 9.7};
  worseResult: Result={disciplineName:"ASC", averageGrade: 4.3};
  constructor() { }

  ngOnInit(): void {
  }

}
