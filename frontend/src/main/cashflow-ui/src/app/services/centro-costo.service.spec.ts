import { TestBed, inject } from '@angular/core/testing';

import { CentroCostoService } from './centro-costo.service';

describe('CentroCostoService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CentroCostoService]
    });
  });

  it('should be created', inject([CentroCostoService], (service: CentroCostoService) => {
    expect(service).toBeTruthy();
  }));
});
