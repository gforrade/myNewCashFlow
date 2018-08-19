import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DataService} from './data.service';
import {HttpErrorHandler} from './exception/http-error-handler.service';
import {ICentroCosto} from '../domain/ICentroCosto';

@Injectable({
  providedIn: 'root'
})
export class CentroCostoService extends DataService<ICentroCosto> {

  constructor(_http: HttpClient, httpErrorHandler: HttpErrorHandler) {
    super('/cashflow/centrosCostos', _http , httpErrorHandler);
  }

}
