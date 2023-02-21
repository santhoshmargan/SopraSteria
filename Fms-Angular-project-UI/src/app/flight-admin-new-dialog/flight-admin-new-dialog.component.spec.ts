import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightAdminNewDialogComponent } from './flight-admin-new-dialog.component';

describe('FlightAdminNewDialogComponent', () => {
  let component: FlightAdminNewDialogComponent;
  let fixture: ComponentFixture<FlightAdminNewDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlightAdminNewDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightAdminNewDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
