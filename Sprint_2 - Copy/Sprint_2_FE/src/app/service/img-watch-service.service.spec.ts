import { TestBed } from '@angular/core/testing';

import { ImgWatchServiceService } from './img-watch-service.service';

describe('ImgWatchServiceService', () => {
  let service: ImgWatchServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImgWatchServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
