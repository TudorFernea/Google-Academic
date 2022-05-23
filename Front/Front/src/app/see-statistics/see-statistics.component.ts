import { Component, OnInit } from '@angular/core';
import { Result } from '../models/curriculum';
import { faTrophy } from '@fortawesome/free-solid-svg-icons';
import { faRightFromBracket } from '@fortawesome/free-solid-svg-icons';
import { TeacherService } from '../services/teacher.service';
@Component({
  selector: 'app-see-statistics',
  templateUrl: './see-statistics.component.html',
  styleUrls: ['./see-statistics.component.css']
})
export class SeeStatisticsComponent implements OnInit {
  bestResult!: Result;
  worseResult: Result={disciplineName:"ASC", averageGrade: 4.3};
  faTrophy = faTrophy;
  logOut=faRightFromBracket;

  constructor(private teacherService: TeacherService) { }

  ngOnInit(): void {
    this.teacherService.getDisciplineWithBestResults().subscribe(
      result=>this.bestResult=result
    )
  }

}
