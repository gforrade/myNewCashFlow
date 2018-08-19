import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs/index';
import {HandleError, HttpErrorHandler} from "./exception/http-error-handler.service";
import {catchError} from "rxjs/internal/operators";

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'my-auth-token',
    'Access-Control-Allow-Origin': 'http://localhost:4200/*',
    'Access-Control-Allow-Methods': 'GET, POST, OPTIONS',
    'Access-Control-Allow-Headers': 'Origin, X-Requested-With, Content-Type, Accept'
  })
};

@Injectable({
  providedIn: 'root'
})

export class DataService<T> {

  private handleError: HandleError;

  constructor(
    private _url: string ,
    private _http: HttpClient,
    httpErrorHandler: HttpErrorHandler
  ) {
    this.handleError = httpErrorHandler.createHandleError('DataService');
  }

  getAll() : Observable<T[]> {
    return this._http.get<T[]>(this._url)
    .pipe(
        catchError(this.handleError(
          'getAll', []))
    );
  }

  create(resource: T){
    return this._http.post<T>(this._url,resource)
    .pipe(
        catchError(this.handleError('create', resource))
     );
  }

  update(resource: T, id): Observable<T>{
    return this._http.put<T>(this._url+'/'+id,resource)
    .pipe(
      catchError(this.handleError('update', resource))
    );
  }

  delete(id): Observable<{}>{
    return this._http.delete<T>(this._url+'/'+id)
    .pipe(
      catchError(this.handleError('delete'))
    );
  }

  get(id: any) : Observable<T> {
    return this._http.get<T>(this._url+'/'+id)
    .pipe(
      catchError(this.handleError('getHeroes', id))
    );
  }
/*
  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  };
*/
}
