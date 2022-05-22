import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Disciplines, Student, YearOfStudy } from '../models/curriculum';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  private yearUrl: string="http://localhost:8080/api/yearOfStudy";
  private disciplineUrl: string="http://localhost:8080/api/discipline";
  private teacherUrl: string="http://localhost:8080/api/teacher";
  private studentUrl: string="http://localhost:8080/api/student"
  constructor(
    private http: HttpClient,
  ) { }

  getAllStudentByDiscipline(disciplineid: number):  Observable<Student[]>{
    const url = `${this.studentUrl}/studentsByDiscipline/${disciplineid}`;
    return this.http.post<Student[]>(url, disciplineid);
  }
  
  getAllYearOfStudy(): Observable<YearOfStudy[]>{
    const url = `${this.yearUrl}/getAll`;
    return this.http.get<YearOfStudy[]>(url);
  }

  getAllDisciplineByTeacher(username:string): Observable<Disciplines[]>{
    const url = `${this.teacherUrl}/getAllDiscipline/${username}`;
    return this.http.post<Disciplines[]>(url, username);
  }

  getDisciplineByYearOfStudy(yearOfStudy: YearOfStudy): Observable<Disciplines[]>{
    const url = `${this.teacherUrl}/getAllByYear`;
    return this.http.post<Disciplines[]>(url, yearOfStudy);
  }

}