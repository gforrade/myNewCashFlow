import {Component, OnInit, ViewChild} from '@angular/core';
import {ICategoria} from '../domain/ICategoria';
import {ITdDataTableColumn, ITdDataTableSortChangeEvent, TdDataTableComponent, TdDialogService, TdLoadingService} from '@covalent/core';
import {CategoriaService} from '../services/categoria.service';
import {MessageService} from '../services/exception/message.service';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'categorias',
  templateUrl: './categorias.component.html',
  styleUrls: ['./categorias.component.css']
})
export class CategoriasComponent implements OnInit {

  categorias : ICategoria[] = [];
  categoria: ICategoria;
  sortBy;
  sortOrder;
  @ViewChild('dataTableCategorias') dataTableComponent: TdDataTableComponent;


  columns:  ITdDataTableColumn[] = [
    {name: 'nombre', label: 'Nombre', sortable: true},
    {name: 'descripcion', label: 'Descripción', sortable: false},
    {name: 'tipo', label: 'Tipo', sortable: false},
    {name: 'centroCosto.nombre', label: 'Centro Costo', sortable: false},
    {name: 'grupo.nombre', label: 'Grupo', sortable: false},
    {name: 'operations', label: 'Acciones', sortable: false},
  ];


  constructor(
    private service: CategoriaService,
    private _dialogService: TdDialogService,
    private _messageService: MessageService,
    private _snackBarService: MatSnackBar,
    private _loadingService: TdLoadingService
  ) { }

  loadAll() {
    this.categorias = [];
    this.service.getAll()
      .subscribe(
        (categorias: ICategoria[]) => {
          this.categorias = categorias;
          this.dataTableComponent.refresh();
          console.log(categorias);
        },
        error => {
          console.log('Error mio ' , error );
          alert('Un error inesperado a ocurrido');
        })
  }

  ngOnInit() {
    this.loadAll();
    console.log(this.categorias);
  }

  sort(sortEvent: ITdDataTableSortChangeEvent): void {
    this.sortBy = sortEvent.name;
    this.sortOrder = sortEvent.order;
  }


  deleteCategoria(categoria: ICategoria)
  {
    this._loadingService.register('categoria.list');
    this._dialogService
      .openConfirm({message: 'Esta seguro que quiere borrar esta categoria?'})
      .afterClosed().toPromise().then((confirm: boolean) => {
      if (confirm) {
        this.service.delete(categoria.id)
          .subscribe( () => {
              this._snackBarService.open('Categoria eliminada Exitosamente', 'Ok');
              this.loadAll();
            },
            error => {
              this._dialogService.openAlert({message: 'Hubo un error al intentar eliminar la categoria: ' + this._messageService.messages});
            }
          );
      }
    });
    this._loadingService.resolve('categoria.list');
  }

  search($event) {
    console.log($event);
  }

}
