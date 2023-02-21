import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyBookingDialogComponent } from './my-booking-dialog.component';

describe('MyBookingDialogComponent', () => {
  let component: MyBookingDialogComponent;
  let fixture: ComponentFixture<MyBookingDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyBookingDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyBookingDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
