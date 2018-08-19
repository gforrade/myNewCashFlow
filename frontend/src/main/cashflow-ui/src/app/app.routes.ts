import {RouterModule, Routes} from '@angular/router';
import {CentrosCostoComponent} from './centros-costo/centros-costo.component';
import {GruposComponent} from './grupos/grupos.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {TarjetasCreditoComponent} from './tarjetas-credito/tarjetas-credito.component';
import {LoginComponent} from './login/login.component';
import {MainComponent} from './main/main.component';
import {HomeComponent} from './home/home.component';
import {CategoriasComponent} from './categorias/categorias.component';
import {FormCategoriaComponent} from './categorias/form-categoria/form-categoria.component';


const routes: Routes = [{
  path: 'login',
  component: LoginComponent,
}, {
  path: '',
  component: MainComponent,
  children: [
    { path: '', component: HomeComponent },
    { path: 'centroscostos', component: CentrosCostoComponent },
    { path: 'categorias', component: CategoriasComponent },
    { path: 'categoria/:id/edit', component: FormCategoriaComponent },
    { path: 'categoria/add', component: FormCategoriaComponent },
    { path: 'grupos', component: GruposComponent },
    { path: 'tarjetas-credito', component: TarjetasCreditoComponent },
    { path: '**', component: NotFoundComponent }
  ],
},
];

export const appRoutes: any = RouterModule.forRoot(routes);
