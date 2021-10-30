import { TestBed } from '@angular/core/testing';

import { Animal.Service.TsService } from './animal.service';

describe('Animal.Service.TsService', () => {
  let service: Animal.Service.TsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(Animal.Service.TsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
