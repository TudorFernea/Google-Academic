import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChooseYearOfStudyComponent } from './choose-year-of-study.component';

describe('ChooseYearOfStudyComponent', () => {
  let component: ChooseYearOfStudyComponent;
  let fixture: ComponentFixture<ChooseYearOfStudyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChooseYearOfStudyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChooseYearOfStudyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
