import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewResultsStudentsComponent } from './view-results-students.component';

describe('ViewResultsStudentsComponent', () => {
  let component: ViewResultsStudentsComponent;
  let fixture: ComponentFixture<ViewResultsStudentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewResultsStudentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewResultsStudentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
