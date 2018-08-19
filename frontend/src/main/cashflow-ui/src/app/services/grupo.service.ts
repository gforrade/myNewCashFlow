import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DataService} from './data.service';
import {HttpErrorHandler} from './exception/http-error-handler.service';
import {IGrupo} from '../domain/IGrupo';

@Injectable({
  providedIn: 'root'
})
export class GrupoService extends DataService<IGrupo> {

  constructor(_http: HttpClient, httpErrorHandler: HttpErrorHandler) {
    super('/cashflow/grupos', _http , httpErrorHandler);
  }

}
