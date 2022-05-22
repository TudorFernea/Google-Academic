import { TestBed } from '@angular/core/testing';

import { EnrolService } from './enrol.service';

describe('EnrollService', () => {
  let service: EnrolService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EnrolService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
