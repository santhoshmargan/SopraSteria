import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AvailableFlightsDialogComponent } from './available-flights-dialog.component';

describe('AvailableFlightsDialogComponent', () => {
  let component: AvailableFlightsDialogComponent;
  let fixture: ComponentFixture<AvailableFlightsDialogComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AvailableFlightsDialogComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AvailableFlightsDialogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
