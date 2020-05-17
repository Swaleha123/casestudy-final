import { TestBed } from '@angular/core/testing';

import { MockquizService } from './mockquiz.service';

describe('MockquizService', () => {
  let service: MockquizService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MockquizService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
