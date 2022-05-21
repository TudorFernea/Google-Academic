import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { firstValueFrom, Observable } from 'rxjs';
import { AuthService } from '../Servicies/auth.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  constructor(private auth: AuthService,
              private router: Router) {

  }

  async canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot) {
    if (this.auth.isLoggedIn()) return true;

    if (AuthService.getRefreshToken()) {
      await firstValueFrom(this.auth.refreshLogin());
    }

    if (this.auth.isLoggedIn()) return true;

    this.router.navigate(['']);
    return false;
  }
  
}
