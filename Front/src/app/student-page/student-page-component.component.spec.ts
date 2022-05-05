import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentPageComponentComponent } from './student-page-component.component';

describe('StudentPageComponentComponent', () => {
  let component: StudentPageComponentComponent;
  let fixture: ComponentFixture<StudentPageComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentPageComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentPageComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
