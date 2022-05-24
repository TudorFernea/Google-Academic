import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrintListStudentsComponent } from './print-list-students.component';

describe('PrintListStudentsComponent', () => {
  let component: PrintListStudentsComponent;
  let fixture: ComponentFixture<PrintListStudentsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PrintListStudentsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PrintListStudentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
