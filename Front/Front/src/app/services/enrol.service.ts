import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Disciplines, YearOfStudy } from '../models/curriculum';

@Injectable({
  providedIn: 'root'
})
export class EnrolService {

  private yearUrl: string="http://localhost:8080/api/yearOfStudy";
  private disciplineUrl: string="http://localhost:8080/api/discipline";
  private studentUrl: string="http://localhost:8080/api/student";
  constructor(
    private http: HttpClient,
  ) { }

  
  enrol(username: string, yearOfStudy:YearOfStudy): Observable<string>{
    const url = `${this.studentUrl}/enrol/${username}`
    return this.http.post<string>(url, yearOfStudy);
  }
  getAllYearOfStudy(): Observable<YearOfStudy[]>{
    const url = `${this.yearUrl}/getAll`;
    return this.http.get<YearOfStudy[]>(url);
  }

  getAllYearOfStudyByStudent(username:string): Observable<YearOfStudy[]>{
    const url = `${this.studentUrl}/getAllYearOfStudy/${username}`;
    return this.http.get<YearOfStudy[]>(url);
  }

  getDisciplineByYearOfStudy(yearOfStudy: YearOfStudy): Observable<Disciplines[]>{
    const url = `${this.disciplineUrl}/getMandatoryByYear`;
    return this.http.post<Disciplines[]>(url, yearOfStudy);
  }

  getOptionalDisciplineByYearOfStudy(yearOfStudy: YearOfStudy): Observable<Disciplines[]>{
    const url = `${this.disciplineUrl}/getOptionalByYear`;
    return this.http.post<Disciplines[]>(url, yearOfStudy);
  }

}
