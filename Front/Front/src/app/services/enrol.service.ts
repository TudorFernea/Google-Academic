import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Disciplines, GradeDiscipline, YearOfStudy } from '../models/curriculum';

@Injectable({
  providedIn: 'root'
})
export class EnrolService {

  private yearUrl: string="http://localhost:8080/api/yearOfStudy";
  private disciplineUrl: string="http://localhost:8080/api/discipline";
  private studentUrl: string="http://localhost:8080/api/student";
  private gradeUrl: string="http://localhost:8080/api/grade";
  private choiceUrl: string="http://localhost:8080/api/choice"


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

  getGradesByYearOfStudy(yearOfStudy: YearOfStudy, username: string): Observable<GradeDiscipline[]>{
    const url= `${this.gradeUrl}/getByYear/${username}`;
    return this.http.post<GradeDiscipline[]>(url, yearOfStudy);
  }

  updateChoices(username: string, disciplines: Disciplines[]): Observable<boolean> {
    const url= `${this.choiceUrl}/update/${username}`;
    return this.http.post<boolean>(url,disciplines);
  }

}
