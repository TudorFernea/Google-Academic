//created service for backend connection

import { Injectable, Output } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map, Observable } from 'rxjs';
import { JwtHelperService } from '@auth0/angular-jwt';

export type TokensResponse = {
  accessToken: string;
  refreshToken: string;
}

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient, private jwtHelper: JwtHelperService) { }
  
  loginUser(username: string, password: string): Observable<null> {
    const formData = new FormData();
    formData.append('username', username);
    formData.append('password', password);
    return this.http.post<TokensResponse>('http://localhost:8080/login', formData).pipe(map(response => {
      localStorage.setItem("accessToken", response.accessToken);
      localStorage.setItem("refreshToken", response.refreshToken);
      return null;
    }));
  }

  refreshLogin(): Observable<null> {
    let headers = new HttpHeaders();
    let refreshToken = AuthService.getRefreshToken();
    headers.set('Authorization', 'Bearer ' + refreshToken);
    return this.http.get<TokensResponse>('http://localhost:8080/home/refreshtoken', {
      headers
    }).pipe(map(response => {
      localStorage.setItem("accessToken", response.accessToken);
      localStorage.setItem("refreshToken", response.refreshToken);
      return null;
    }))
  }

  getRoles() {
    const accessToken=AuthService.getAccessToken();
    return this.jwtHelper.decodeToken(accessToken==null?undefined:accessToken).roles;
  }

  logout() {
    // localStorage.setItem("faculty", '');
    localStorage.removeItem("faculties")
    localStorage.removeItem("accessToken");
    localStorage.removeItem("refreshToken");
    localStorage.clear();
  }

  isLoggedIn() {
    const accessToken=AuthService.getAccessToken();
    return !this.jwtHelper.isTokenExpired(accessToken==null?undefined:accessToken);
  }

  static getAccessToken() {
    return localStorage.getItem("accessToken") as string | null ;
  }

  static getRefreshToken() {
    return localStorage.getItem("refreshToken") as string | null;
  }
}
