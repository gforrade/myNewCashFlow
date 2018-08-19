import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TarjetasCreditoComponent } from './tarjetas-credito.component';

describe('TarjetasCreditoComponent', () => {
  let component: TarjetasCreditoComponent;
  let fixture: ComponentFixture<TarjetasCreditoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TarjetasCreditoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TarjetasCreditoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
