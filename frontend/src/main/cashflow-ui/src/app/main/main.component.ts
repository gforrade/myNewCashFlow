import { Component, HostBinding, ChangeDetectionStrategy } from '@angular/core';
import { TdMediaService } from '@covalent/core/media';
import {Router} from '@angular/router';
import {SecurityService} from '../services/security.service';

@Component({
  changeDetection: ChangeDetectionStrategy.OnPush,
  selector: 'main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent {

  routes: Object[] = [{
    icon: 'home',
    route: '/centroscostos',
    title: 'Centro Costos',
  }, {
    icon: 'library_books',
    route: '/grupos',
    title: 'Grupos',
  }, {
    icon: 'color_lens',
    route: '/tarjetas-credito',
    title: 'Tarjeta Creditos',
  } ,
  {
    icon: 'color_lens',
    route: '/categorias',
    title: 'Categorias',
  }
  ];
  usermenu: Object[] = [{
    icon: 'swap_horiz',
    route: '.',
    title: 'Switch account',
  }, {
    icon: 'tune',
    route: '.',
    title: 'Account settings',
  }, {
    icon: 'exit_to_app',
    route: '.',
    title: 'Sign out',
  },
  ];
  navmenu: Object[] = [{
    icon: 'looks_one',
    route: '.',
    title: 'First item',
    description: 'Item description',
  }, {
    icon: 'looks_two',
    route: '.',
    title: 'Second item',
    description: 'Item description',
  }, {
    icon: 'looks_3',
    route: '.',
    title: 'Third item',
    description: 'Item description',
  }, {
    icon: 'looks_4',
    route: '.',
    title: 'Fourth item',
    description: 'Item description',
  }, {
    icon: 'looks_5',
    route: '.',
    title: 'Fifth item',
    description: 'Item description',
  },
  {
    icon: 'looks_5',
    route: '.',
    title: 'Fifth item',
    description: 'Item description',
  }
  ];

  constructor(public media: TdMediaService,
              private _security: SecurityService) {}

  logout(): void {
    this._security.logout();
  }
}
