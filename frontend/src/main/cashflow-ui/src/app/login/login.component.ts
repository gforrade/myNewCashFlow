import {Component, ElementRef, Inject, OnInit, ViewChild} from '@angular/core';
import {SecurityService} from '../services/security.service';
import {Router} from '@angular/router';
import {DOCUMENT} from '@angular/common';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private window: any;

  @ViewChild('Hinter')
  private hinter: ElementRef;

  username: string;
  password: string;
  inValid: boolean = true;
  showPassword: boolean = false;


  constructor(@Inject(DOCUMENT) private _document: Document,
              private router: Router,
              private _security: SecurityService) {
    this.window = window;
  }

  ngOnInit() {
  }

  validate(): void {
    this.hinter.nativeElement.innerHTML = '';
    this.inValid = !(this.username && this.password);
  }

  login(): void {

    this.hinter.nativeElement.innerHTML = '';

    this.validate();
    if (this.inValid) {
      let span: Element =  this._document.createElement('span');

      span.setAttribute('class', 'tc-red-600');
      span.textContent = 'El nombre de usuario o contraseña son obligatorios';

      this.hinter.nativeElement.appendChild(span);
      return;
    }

    console.log('Log in as ' + this.username);
    const loginData: any = {
      username: this.username,
      password: this.password,
    };

    this._security.logIn(loginData).subscribe(
      (success: boolean) => {
        if (success) {
          this.router.navigate(['/']);
        } else {
          let span: Element = this._document.createElement('span');

          span.setAttribute('class', 'tc-red-600');
          span.textContent = 'El nombre de usuario o contraseña no son correctos';

          this.hinter.nativeElement.appendChild(span);
        }
      });
  }

}
