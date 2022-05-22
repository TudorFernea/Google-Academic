import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChiefTeacherPageComponent } from './chief-teacher-page.component';

describe('ChiefTeacherPageComponent', () => {
  let component: ChiefTeacherPageComponent;
  let fixture: ComponentFixture<ChiefTeacherPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChiefTeacherPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChiefTeacherPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
