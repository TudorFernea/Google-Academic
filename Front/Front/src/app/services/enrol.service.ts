import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EnrollService {

  private logInUrl: string="http://localhost:8080/api/Login";

  constructor(
    private http: HttpClient,
  ) { }

  enrol(student: number, password: string): Observable<boolean>{
    return this.http.post<boolean>(this.logInUrl, {email, password}).pipe(
      catchError(_ => {alert("Error"); return of(false);})
  
    );
  }

}
