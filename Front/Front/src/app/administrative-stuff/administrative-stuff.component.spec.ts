import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdministrativeStuffComponent } from './administrative-stuff.component';

describe('AdministrativeStuffComponent', () => {
  let component: AdministrativeStuffComponent;
  let fixture: ComponentFixture<AdministrativeStuffComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdministrativeStuffComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdministrativeStuffComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
