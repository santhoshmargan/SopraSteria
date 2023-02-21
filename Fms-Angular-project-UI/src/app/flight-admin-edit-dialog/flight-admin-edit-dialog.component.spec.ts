import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FlightAdminEditDialogComponent } from './flight-admin-edit-dialog.component';

describe('FlightAdminEditDialogComponent', () => {
  let component: FlightAdminEditDialogComponent;
  let fixture: ComponentFixture<FlightAdminEditDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FlightAdminEditDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FlightAdminEditDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
