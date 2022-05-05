import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, of } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SignUpService {
  private logInUrl: string="https://localhost:8080/api/Registration"; //????

  constructor( private http: HttpClient,) { }
  signUp(name: string,surname: string,username: string, email:string, password: string, confirmPassword: string): Observable<boolean>{
    return this.http.post<boolean>(`${this.logInUrl}`, {name, surname,username,email,password,confirmPassword}).pipe(
      catchError(_ => {alert("Error"); return of(false);})
  
    );
  }

}
