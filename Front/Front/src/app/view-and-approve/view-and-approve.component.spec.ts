import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewAndApproveComponent } from './view-and-approve.component';

describe('ViewAndApproveComponent', () => {
  let component: ViewAndApproveComponent;
  let fixture: ComponentFixture<ViewAndApproveComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewAndApproveComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewAndApproveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
