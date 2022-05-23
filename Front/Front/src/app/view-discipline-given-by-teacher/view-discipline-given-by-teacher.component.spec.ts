import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewDisciplineGivenByTeacherComponent } from './view-discipline-given-by-teacher.component';

describe('ViewDisciplineGivenByTeacherComponent', () => {
  let component: ViewDisciplineGivenByTeacherComponent;
  let fixture: ComponentFixture<ViewDisciplineGivenByTeacherComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewDisciplineGivenByTeacherComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewDisciplineGivenByTeacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
