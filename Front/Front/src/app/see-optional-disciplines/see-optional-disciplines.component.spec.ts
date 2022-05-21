import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeOptionalDisciplinesComponent } from './see-optional-disciplines.component';

describe('SeeOptionalDisciplinesComponent', () => {
  let component: SeeOptionalDisciplinesComponent;
  let fixture: ComponentFixture<SeeOptionalDisciplinesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeeOptionalDisciplinesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeeOptionalDisciplinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
