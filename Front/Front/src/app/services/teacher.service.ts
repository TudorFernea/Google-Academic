import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, of } from 'rxjs';
import { ApprovedOptional, Disciplines, Student, YearOfStudy } from '../models/curriculum';

@Injectable({
  providedIn: 'root'
})
export class TeacherService {

  private yearUrl: string="http://localhost:8080/api/yearOfStudy";
  private disciplineUrl: string="http://localhost:8080/api/discipline";
  private teacherUrl: string="http://localhost:8080/api/teacher";
  private studentUrl: string="http://localhost:8080/api/student"
  private gradeUrl: string="http://localhost:8080/api/grade"
  private choiceUrl: string="http://localhost:8080/api/choice"

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

  getAllYearOfStudyByTeacher(username:string): Observable<YearOfStudy[]>{
    const url = `${this.teacherUrl}/getAllYearOfStudy/${username}`;
    return this.http.get<YearOfStudy[]>(url);
  }

  getAllDisciplineByTeacher(username:string): Observable<Disciplines[]>{
    const url = `${this.teacherUrl}/getAllDiscipline/${username}`;
    return this.http.post<Disciplines[]>(url, username);
  }

  getAllOptionalByFaculty(username: string): Observable<Disciplines[]>{
    const url = `${this.disciplineUrl}/getOptionalByFaculty/${username}`;
    return this.http.get<Disciplines[]>(url);
  }

  getDisciplineByYearOfStudy(yearOfStudy: YearOfStudy): Observable<Disciplines[]>{
    const url = `${this.teacherUrl}/getAllByYear`;
    return this.http.post<Disciplines[]>(url, yearOfStudy);
  }

  addDiscipline(name: string, nrcredit: number, description: string, username: string, yearOfStudyId: number): Observable<boolean>{
      const url = `${this.disciplineUrl}/addOptional`;
      return this.http.post<boolean>(url, {username,name, nrcredit, description, yearOfStudyId});
  }

  addGrade(grade: string | undefined, disciplineId: number, studentId: number): Observable<boolean> {
      const url = `${this.gradeUrl}/add`;
      return this.http.post<boolean>(url, {grade, disciplineId, studentId});
  }

  assignOptionals(approvedOptionals:ApprovedOptional[]): Observable<boolean>{
      const url=`${this.choiceUrl}/assign`;
      return this.http.post<boolean>(url, approvedOptionals);
  }

  /*
  getTeacher(username: string): Observable<number>{
    const url = `${this.teacherUrl}/get/${username}`;
    return this.http.post<number>(url, username);
  }
  */

}