import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, of } from "rxjs";

export type respone = {
  message: string;
}

@Injectable({
  providedIn: 'root'
})
export class SignUpService {
  private logInUrl: string="http://localhost:8080/api/Registration"; //????

  constructor( private http: HttpClient,) { }
  signUp(firstName: string,lastName: string,username: string, email:string, password: string, confirmationPassword: string, role: string): Observable<boolean>{
    return this.http.post<boolean>('http://localhost:8080/api/Registration', {firstName, lastName,username,email,password,confirmationPassword, role}).pipe(
      catchError(_ => {alert("Error"); return of(false);})

    );
  }

}
