import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {DataService} from './data.service';
import {HttpErrorHandler} from './exception/http-error-handler.service';
import {ICategoria} from '../domain/ICategoria';

@Injectable({
  providedIn: 'root'
})
export class CategoriaService extends DataService<ICategoria> {

  constructor(_http: HttpClient, httpErrorHandler: HttpErrorHandler) {
    super('/cashflow/categorias', _http , httpErrorHandler);
  }

}
