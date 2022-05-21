import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, of } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private logInUrl: string="http://localhost:8080/api/Login";

  constructor(
    private http: HttpClient,
  ) { }

  logIn(email: string, password: string): Observable<boolean>{
    return this.http.post<boolean>(this.logInUrl, {email, password}).pipe(
      catchError(_ => {alert("Error"); return of(false);})
  
    );
  }

}
