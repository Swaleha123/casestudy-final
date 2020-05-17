import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MockquizComponent } from './mockquiz.component';

describe('MockquizComponent', () => {
  let component: MockquizComponent;
  let fixture: ComponentFixture<MockquizComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MockquizComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MockquizComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
