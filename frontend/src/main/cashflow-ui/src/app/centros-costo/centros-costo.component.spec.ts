import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CentrosCostoComponent } from './centros-costo.component';

describe('CentrosCostoComponent', () => {
  let component: CentrosCostoComponent;
  let fixture: ComponentFixture<CentrosCostoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CentrosCostoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CentrosCostoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
