import {IGrupo} from './IGrupo';
import {ICentroCosto} from './ICentroCosto';

export interface ICategoria {
  id: number;
  nombre: string;
  descripcion: string;
  tipo: string;
  grupo: IGrupo;
  centroCosto: ICentroCosto;
}


