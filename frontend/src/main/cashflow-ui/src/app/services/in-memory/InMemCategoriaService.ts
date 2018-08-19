import { InMemoryDbService } from 'angular-in-memory-web-api';
import {ICategoria} from '../../domain/ICategoria';

export class InMemCategoriaService implements InMemoryDbService {
  createDb() {
/*
    const categorias: ICategoria[] = [
      {id: 1, nombre: 'Categoria_1' , descripcion: 'Descripcion Categoria 1'},
      {id: 2, nombre: 'Categoria_2' , descripcion: 'Descripcion Categoria 2'},
      {id: 3, nombre: 'Categoria_3' , descripcion: 'Descripcion Categoria 3'},
      {id: 4, nombre: 'Categoria_4' , descripcion: 'Descripcion Categoria 4'},
      {id: 5, nombre: 'Categoria_5' , descripcion: 'Descripcion Categoria 5'},
      {id: 6, nombre: 'Categoria_6' , descripcion: 'Descripcion Categoria 6'},
      {id: 7, nombre: 'Categoria_7' , descripcion: 'Descripcion Categoria 7'},
      {id: 8, nombre: 'Categoria_8' , descripcion: 'Descripcion Categoria 8'},
      {id: 9, nombre: 'Categoria_9' , descripcion: 'Descripcion Categoria 9'}
    ];
*/

    const categorias: ICategoria[] = [
        {
          'id': 93,
          'nombre': 'MonotributoGaby',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 3,
            'nombre': null,
            'descripcion': null
          },
          'centroCosto': {
            'id': 2,
            'nombre': 'Caro',
            'descripcion': 'Centro Costo Caro'
          }
        },
        {
          'id': 94,
          'nombre': 'OSDE',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 9,
            'nombre': 'Salud',
            'descripcion': null
          },
          'centroCosto': {
            'id': 2,
            'nombre': 'Caro',
            'descripcion': 'Centro Costo Caro'
          }
        },
        {
          'id': 95,
          'nombre': 'Sicologo Caro',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 9,
            'nombre': 'Salud',
            'descripcion': null
          },
          'centroCosto': {
            'id': 2,
            'nombre': 'Caro',
            'descripcion': 'Centro Costo Caro'
          }
        },
        {
          'id': 96,
          'nombre': 'Sicologo Gaby',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 9,
            'nombre': 'Salud',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 97,
          'nombre': 'Sicologo Tomi',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 9,
            'nombre': 'Salud',
            'descripcion': null
          },
          'centroCosto': {
            'id': 3,
            'nombre': 'Hijos',
            'descripcion': 'Centro Costo Hijos'
          }
        },
        {
          'id': 98,
          'nombre': 'Gastos Mantenimento Tarjetas\t',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 5,
            'nombre': 'Tarjetas Credito',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 99,
          'nombre': 'Hijos',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 5,
            'nombre': 'Tarjetas Credito',
            'descripcion': null
          },
          'centroCosto': {
            'id': 3,
            'nombre': 'Hijos',
            'descripcion': 'Centro Costo Hijos'
          }
        },
        {
          'id': 100,
          'nombre': 'Gaby',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 5,
            'nombre': 'Tarjetas Credito',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 101,
          'nombre': 'Caro',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 5,
            'nombre': 'Tarjetas Credito',
            'descripcion': null
          },
          'centroCosto': {
            'id': 2,
            'nombre': 'Caro',
            'descripcion': 'Centro Costo Caro'
          }
        },
        {
          'id': 102,
          'nombre': 'Varios',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 5,
            'nombre': 'Tarjetas Credito',
            'descripcion': null
          },
          'centroCosto': {
            'id': 4,
            'nombre': 'Varios',
            'descripcion': 'Centro Costo Varios'
          }
        },
        {
          'id': 103,
          'nombre': 'Cuota Colegio Tomas',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 4,
            'nombre': 'Educación',
            'descripcion': 'Descripcion Educacion'
          },
          'centroCosto': {
            'id': 3,
            'nombre': 'Hijos',
            'descripcion': 'Centro Costo Hijos'
          }
        },
        {
          'id': 104,
          'nombre': 'Cuota Colegio Ana Paula',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 4,
            'nombre': 'Educación',
            'descripcion': 'Descripcion Educacion'
          },
          'centroCosto': {
            'id': 3,
            'nombre': 'Hijos',
            'descripcion': 'Centro Costo Hijos'
          }
        },
        {
          'id': 105,
          'nombre': 'Rugby',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 6,
            'nombre': 'Esparcimiento',
            'descripcion': null
          },
          'centroCosto': {
            'id': 3,
            'nombre': 'Hijos',
            'descripcion': 'Centro Costo Hijos'
          }
        },
        {
          'id': 106,
          'nombre': 'Danza',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 6,
            'nombre': 'Esparcimiento',
            'descripcion': null
          },
          'centroCosto': {
            'id': 3,
            'nombre': 'Hijos',
            'descripcion': 'Centro Costo Hijos'
          }
        },
        {
          'id': 107,
          'nombre': 'Gimnasio Gaby',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 6,
            'nombre': 'Esparcimiento',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 108,
          'nombre': 'Natacion Caro',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 6,
            'nombre': 'Esparcimiento',
            'descripcion': null
          },
          'centroCosto': {
            'id': 2,
            'nombre': 'Caro',
            'descripcion': 'Centro Costo Caro'
          }
        },
        {
          'id': 109,
          'nombre': 'Salidas Gaby',
          'descripcion': '\tSalidas\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 6,
            'nombre': 'Esparcimiento',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 110,
          'nombre': 'Cuota 308',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 8,
            'nombre': 'Préstamos',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 111,
          'nombre': 'Cuota Clio',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 8,
            'nombre': 'Préstamos',
            'descripcion': null
          },
          'centroCosto': {
            'id': 2,
            'nombre': 'Caro',
            'descripcion': 'Centro Costo Caro'
          }
        },
        {
          'id': 112,
          'nombre': 'Prestamo Personal',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 8,
            'nombre': 'Préstamos',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 113,
          'nombre': 'Credito Hipotecario',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 8,
            'nombre': 'Préstamos',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 114,
          'nombre': 'Supermercado Caro',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 7,
            'nombre': 'Alimentación',
            'descripcion': null
          },
          'centroCosto': {
            'id': 2,
            'nombre': 'Caro',
            'descripcion': 'Centro Costo Caro'
          }
        },
        {
          'id': 115,
          'nombre': 'Supermercado Gaby',
          'descripcion': '\tDescripcion de MODIFICADO HOY nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 7,
            'nombre': 'Alimentación',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 73,
          'nombre': 'Expensas Medano',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 6,
            'nombre': 'Casa Medano',
            'descripcion': 'Centro Costo Super Caro'
          }
        },
        {
          'id': 74,
          'nombre': 'Celular Caro',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 2,
            'nombre': 'Caro',
            'descripcion': 'Centro Costo Caro'
          }
        },
        {
          'id': 75,
          'nombre': 'Luz Medano',
          'descripcion': 'Descripcion de nombre',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 6,
            'nombre': 'Casa Medano',
            'descripcion': 'Centro Costo Super Caro'
          }
        },
        {
          'id': 76,
          'nombre': 'Luz Dto Caro',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 5,
            'nombre': 'Dto Caro',
            'descripcion': 'Centro Costo Familia'
          }
        },
        {
          'id': 77,
          'nombre': 'Municipalidad Dto Caro',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 5,
            'nombre': 'Dto Caro',
            'descripcion': 'Centro Costo Familia'
          }
        },
        {
          'id': 78,
          'nombre': 'Gas Dto Caro',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 5,
            'nombre': 'Dto Caro',
            'descripcion': 'Centro Costo Familia'
          }
        },
        {
          'id': 79,
          'nombre': 'Agua Dto Caro',
          'descripcion': 'Descripcion de nombre',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 5,
            'nombre': 'Dto Caro',
            'descripcion': 'Centro Costo Familia'
          }
        },
        {
          'id': 80,
          'nombre': 'Alquiler Dto Caro',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 5,
            'nombre': 'Dto Caro',
            'descripcion': 'Centro Costo Familia'
          }
        },
        {
          'id': 81,
          'nombre': 'DirecTV Medano',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 6,
            'nombre': 'Casa Medano',
            'descripcion': 'Centro Costo Super Caro'
          }
        },
        {
          'id': 82,
          'nombre': 'DirecTV Dto Caro',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 5,
            'nombre': 'Dto Caro',
            'descripcion': 'Centro Costo Familia'
          }
        },
        {
          'id': 83,
          'nombre': 'Jardinero Medano',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 6,
            'nombre': 'Casa Medano',
            'descripcion': 'Centro Costo Super Caro'
          }
        },
        {
          'id': 84,
          'nombre': 'Empleada Medano',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 6,
            'nombre': 'Casa Medano',
            'descripcion': 'Centro Costo Super Caro'
          }
        },
        {
          'id': 85,
          'nombre': 'Speedy Dto Caro',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 5,
            'nombre': 'Dto Caro',
            'descripcion': 'Centro Costo Familia'
          }
        },
        {
          'id': 86,
          'nombre': 'xFly Medano',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 6,
            'nombre': 'Casa Medano',
            'descripcion': 'Centro Costo Super Caro'
          }
        },
        {
          'id': 87,
          'nombre': 'Seguro Clio',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 2,
            'nombre': 'Transporte',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 88,
          'nombre': 'Patente Clio',
          'descripcion': 'Descripcion de nombre\tClio',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 2,
            'nombre': 'Transporte',
            'descripcion': null
          },
          'centroCosto': {
            'id': 2,
            'nombre': 'Caro',
            'descripcion': 'Centro Costo Caro'
          }
        },
        {
          'id': 89,
          'nombre': 'Nafta Clio',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 2,
            'nombre': 'Transporte',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 90,
          'nombre': 'Seguro 308',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 2,
            'nombre': 'Transporte',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 91,
          'nombre': 'Patente 308',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 2,
            'nombre': 'Transporte',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 92,
          'nombre': 'Nafta 308',
          'descripcion': '\tDescripcion de nombre\t',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 2,
            'nombre': 'Transporte',
            'descripcion': null
          },
          'centroCosto': {
            'id': 1,
            'nombre': 'Gaby',
            'descripcion': 'Centro Costo Gaby'
          }
        },
        {
          'id': 71,
          'nombre': 'Clinica Luang',
          'descripcion': '\tGastos Luang',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 10,
            'nombre': 'Extras',
            'descripcion': null
          },
          'centroCosto': {
            'id': 2,
            'nombre': 'Caro',
            'descripcion': 'Centro Costo Caro'
          }
        },
        {
          'id': 72,
          'nombre': 'Expensas Dto Caro',
          'descripcion': 'Descripcion de nombre',
          'tipo': 'EGRESO',
          'grupo': {
            'id': 1,
            'nombre': 'Vivienda',
            'descripcion': null
          },
          'centroCosto': {
            'id': 5,
            'nombre': 'Dto Caro',
            'descripcion': 'Centro Costo Familia'
          }
        }
      ]








    console.log(categorias);
    return { categorias };
  }
}
