import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AirportAdminNewDialogComponent } from './airport-admin-new-dialog.component';

describe('AirportAdminNewDialogComponent', () => {
  let component: AirportAdminNewDialogComponent;
  let fixture: ComponentFixture<AirportAdminNewDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AirportAdminNewDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AirportAdminNewDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
