import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {HandleError, HttpErrorHandler} from './exception/http-error-handler.service';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {catchError} from 'rxjs/internal/operators';
import {Router} from '@angular/router';





@Injectable({
  providedIn: 'root'
})
export class SecurityService {

  private handleError: HandleError;
  private readonly _url: string = 'cashflow/security';


  constructor(
    private _http: HttpClient,
    private router: Router,
    httpErrorHandler: HttpErrorHandler
  ) {
    this.handleError = httpErrorHandler.createHandleError('DataService');
  }

  public logIn(loginData: any): Observable<any> {

    let params: URLSearchParams = new URLSearchParams();

    params.append('username', loginData.username);
    params.append('password', loginData.password);

    const httpOptions = {
      headers: new HttpHeaders({
        'Content-type': 'application/x-www-form-urlencoded; charset=utf-8',
        'Authorization': 'Basic ' + btoa(`${loginData.username}:${loginData.password}`),
      })
    };


    return this._http.post(`${this._url}/login`, params.toString(), httpOptions)
      .map((res: any) => {
        return true;
      })
      .pipe(
        catchError(this.handleError('login'))
      );

  }

  public logout(): void {
//    this._cookies.delete(TOKEN_NAME);
    this._http.post(`${this._url}/logout`, null)
      .subscribe((res: any) => {
        this.router.navigate(['/login']);
      }, (err: any) => {
        // TODO: implementar soluciones en estos casos
      });
  }

}
