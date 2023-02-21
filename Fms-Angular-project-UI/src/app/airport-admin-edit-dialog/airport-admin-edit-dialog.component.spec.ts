import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AirportAdminEditDialogComponent } from './airport-admin-edit-dialog.component';

describe('AirportAdminEditDialogComponent', () => {
  let component: AirportAdminEditDialogComponent;
  let fixture: ComponentFixture<AirportAdminEditDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AirportAdminEditDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AirportAdminEditDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
