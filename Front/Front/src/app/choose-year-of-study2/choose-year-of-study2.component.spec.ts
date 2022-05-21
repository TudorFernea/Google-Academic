import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChooseYearOfStudy2Component } from './choose-year-of-study2.component';

describe('ChooseYearOfStudy2Component', () => {
  let component: ChooseYearOfStudy2Component;
  let fixture: ComponentFixture<ChooseYearOfStudy2Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ChooseYearOfStudy2Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ChooseYearOfStudy2Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
