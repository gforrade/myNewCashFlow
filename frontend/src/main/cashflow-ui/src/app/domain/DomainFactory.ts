import {ICategoria} from './ICategoria';
import {IGrupo} from './IGrupo';
import {ICentroCosto} from './ICentroCosto';

export namespace DomainFactory {
  export function createICategoria(): ICategoria {
    let categoria : ICategoria =
      {
        id: undefined,
        nombre: '',
        descripcion: '',
        tipo: '',
        grupo: {
          id: -1
        },
        centroCosto: {
          id: -1,
        }
      } as ICategoria;
    return categoria;
  }

  export function createIGrupo(): IGrupo {
    return ({
      id: -1,
      nombre: '',
      descripcion: '',
    } as IGrupo);
  }

  export function createICentroCosto(): ICentroCosto {
    return ({
      id: -1,
      nombre: '',
      descripcion: '',
    } as ICentroCosto);
  }


}
