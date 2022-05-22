import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssignGradeToStudentComponent } from './assign-grade-to-student.component';

describe('AssignGradeToStudentComponent', () => {
  let component: AssignGradeToStudentComponent;
  let fixture: ComponentFixture<AssignGradeToStudentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssignGradeToStudentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssignGradeToStudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
