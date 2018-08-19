import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import {BrowserAnimationsModule, NoopAnimationsModule} from '@angular/platform-browser/animations';
import { NavbarComponent } from './navbar/navbar.component';
import { CentrosCostoComponent } from './centros-costo/centros-costo.component';
import { TarjetasCreditoComponent } from './tarjetas-credito/tarjetas-credito.component';
import { CategoriasComponent } from './categorias/categorias.component';
import { GruposComponent } from './grupos/grupos.component';
import { HomeComponent } from './home/home.component';
import { NotFoundComponent } from './not-found/not-found.component';
import { MatComponentsModule} from './mat-components.module';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {appRoutes} from './app.routes';
import {MainComponent} from './main/main.component';
import {LoginComponent} from './login/login.component';
import {CovalentComponentsModule} from './covalent-components.module';
import {CommonModule} from '@angular/common';
import {HttpClientModule} from '@angular/common/http';
import { TdMediaService } from '@covalent/core/media';
import {FormCategoriaComponent} from './categorias/form-categoria/form-categoria.component';
import {CategoriaService} from './services/categoria.service';
import {HttpClientInMemoryWebApiModule} from 'angular-in-memory-web-api';
import {InMemCategoriaService} from './services/in-memory/InMemCategoriaService';
import {HttpErrorHandler} from './services/exception/http-error-handler.service';
import {MessageService} from './services/exception/message.service';
import {TdDialogService} from '@covalent/core';
import {GrupoService} from './services/grupo.service';
import {CentroCostoService} from './services/centro-costo.service';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CentrosCostoComponent,
    TarjetasCreditoComponent,
    CategoriasComponent,
    GruposComponent,
    FormCategoriaComponent,
    HomeComponent,
    MainComponent,
    NotFoundComponent,
    LoginComponent
  ],
  imports: [
    HttpClientModule,
    CommonModule,
    BrowserModule,
    BrowserAnimationsModule,
    NoopAnimationsModule,
    MatComponentsModule,
    CovalentComponentsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    // HttpClientInMemoryWebApiModule.forRoot(InMemCategoriaService),
    // routing
    appRoutes
  ],
  providers: [
    TdMediaService,
    CategoriaService,
    GrupoService,
    CentroCostoService,
    HttpErrorHandler,
    MessageService,
    TdDialogService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
