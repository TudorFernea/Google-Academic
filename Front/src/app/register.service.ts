import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError, Observable, of } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private logInUrl: string="api/Login";

  constructor(
    private http: HttpClient,
  ) { }

  logIn(email: string, password: string): Observable<boolean>{
    return this.http.get<boolean>(`${this.logInUrl}?email=${email}&password=${password}`).pipe(
      catchError(_ => {alert("Error"); return of(false);})
  
    );
  }

}
