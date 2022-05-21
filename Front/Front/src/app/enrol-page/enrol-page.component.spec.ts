import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnrolPageComponent } from './enrol-page.component';

describe('EnrolPageComponent', () => {
  let component: EnrolPageComponent;
  let fixture: ComponentFixture<EnrolPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnrolPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EnrolPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
