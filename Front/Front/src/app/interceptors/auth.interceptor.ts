import { Injectable } from '@angular/core';
import {
    HttpRequest,
    HttpHandler,
    HttpEvent,
    HttpInterceptor,
    HttpErrorResponse,
    HTTP_INTERCEPTORS,
} from '@angular/common/http';
import {
    BehaviorSubject,
    catchError,
    filter,
    Observable,
    switchMap,
    take,
    throwError,
} from 'rxjs';
import { AuthService } from '../Servicies/auth.service';

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  private isRefreshing = false;
    private refreshTokenSubject: BehaviorSubject<any> = new BehaviorSubject<any>(
        null
    );

    constructor(private authService: AuthService) {}

    intercept(
        request: HttpRequest<any>,
        next: HttpHandler
    ): Observable<HttpEvent<Object>> {
        let authReq = request;
        const token = AuthService.getAccessToken();
        if (token !== null) {
            authReq = this.addTokenHeader(request, token);
        }
        return next.handle(authReq).pipe(
            catchError(error => {
                if (
                    error instanceof HttpErrorResponse &&
                    !authReq.url.includes('login') &&
                    error.status === 403
                ) {
                    return this.handle403Error(authReq, next);
                }
                return error;
            })
        ) as Observable<HttpEvent<any>>;
    }

    handle403Error(request: HttpRequest<unknown>, next: HttpHandler): any {
      if (!this.isRefreshing) {
          this.isRefreshing = true;
          this.refreshTokenSubject.next(null);
          const token = AuthService.getRefreshToken();
          if (token) {
              return this.authService.refreshLogin().pipe(
                  switchMap(() => {
                      this.isRefreshing = false;
                      this.refreshTokenSubject.next(AuthService.getAccessToken());
                      
                      const accessToken=AuthService.getAccessToken();

                      return next.handle(
                          this.addTokenHeader(request, accessToken==null?undefined:accessToken)
                      );
                  }),
                  catchError(err => {
                      this.isRefreshing = false;

                      this.authService.logout();
                      return throwError(err);
                  })
              );
          }
      }
      return this.refreshTokenSubject.pipe(
          filter(token => token !== null),
          take(1),
          switchMap(token => next.handle(this.addTokenHeader(request, token)))
      );
  }

  addTokenHeader(request: HttpRequest<any>, token: string | undefined) {
    return request.clone({
        headers: request.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token),
    });
  }

}
export const authInterceptorProviders = [
  { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true },
];
