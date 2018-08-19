import { Component, OnInit } from '@angular/core';
import {CategoriaService} from '../../services/categoria.service';
import {ICategoria} from '../../domain/ICategoria';
import {ActivatedRoute, Router} from '@angular/router';
import {TdDialogService, TdLoadingService} from '@covalent/core';
import {IGrupo} from '../../domain/IGrupo';
import {ICentroCosto} from '../../domain/ICentroCosto';
import {GrupoService} from '../../services/grupo.service';
import {CentroCostoService} from '../../services/centro-costo.service';
import {DomainFactory} from '../../domain/DomainFactory';
import {MatSnackBar} from '@angular/material';
import {error} from '@angular/compiler/src/util';
import {MessageService} from '../../services/exception/message.service';

@Component({
  selector: 'app-form-categoria',
  templateUrl: './form-categoria.component.html',
  styleUrls: ['./form-categoria.component.css']
})
export class FormCategoriaComponent implements OnInit {

  categoria: ICategoria;
  action: string;
  grupos: IGrupo[] = [];
  centrosCostos: ICentroCosto[] = [];
  tipos = ['EGRESO','INGRESO'];

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private service: CategoriaService,
    private grupoService: GrupoService,
    private centrosCostosService: CentroCostoService,
    private _snackBarService: MatSnackBar,
    private _loadingService: TdLoadingService,
    private _dialogService: TdDialogService,
    private _messageService: MessageService
  ) {
    // Inicializo con los valores de Grupos y Centros de Costos para las listas de valores
    this.grupoService.getAll()
      .subscribe(
        (grupos : IGrupo[]) => {
          this.grupos = grupos;
          console.log(this.grupos);
        });

    this.centrosCostosService.getAll()
      .subscribe(
        (centrosCostos: ICentroCosto[]) => {
          this.centrosCostos = centrosCostos;
          console.log(centrosCostos);
        });
  }

  ngOnInit() {
    console.log('onInit');
    this.route.url.subscribe((url: any) => {
      console.log(url);
      this.action = (url.length > 1 ? url[1].path : 'add');
    });

    this.route.paramMap.subscribe(
      paramMap => {
        const id = paramMap.get('id');
        if (id) {
          this.service.get(id)
            .subscribe(result => {
              this.categoria = result;
              console.log('categoria leida ' , this.categoria);
            })
        } else {
          this.categoria = DomainFactory.createICategoria();
        }
      }
    )
  }

  save() {
    console.log('save ', this.categoria);

    if (this.categoria.id ) {
      this.service.update(this.categoria,this.categoria.id).subscribe(
        () => {
          this._snackBarService.open('Categoria Guardada Exitosamente', 'Ok');
          this.goBack();
        }, error => {
          this._dialogService.openAlert({message: 'Hubo un error al intentar guardar la categoria: ' + this._messageService.messages});
        }
      )
    } else {
      this.service.create(this.categoria).subscribe(
        () => {
          this._snackBarService.open('Categoria Guardada Exitosamente', 'Ok');
          this.goBack();
        }, error => {
          this._dialogService.openAlert({message: 'Hubo un error al intentar guardar la categoria: '+ this._messageService.messages});
        }
      )
    }

  }

  goBack(): void {
    this.router.navigate(['/categorias']);
  }
}

/*
      this._snackBarService.open('User Saved', 'Ok');
      this.goBack();
    } catch (error) {
      this._dialogService.openAlert({message: 'There was an error saving the user'});
    } finally {
      this._loadingService.resolve('user.form');
    }

 */

