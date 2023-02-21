import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';
import { BookingService } from '../services/booking.service';

@Component({
  selector: 'app-flight-admin-new-dialog',
  templateUrl: './flight-admin-new-dialog.component.html',
  styleUrls: ['./flight-admin-new-dialog.component.scss']
})
export class FlightAdminNewDialogComponent implements OnInit {

  sources: any;
  destinations: any;

  addFlightForm = new FormGroup({
    flightCode: new FormControl(''),
    airlineName: new FormControl(''),
    source: new FormControl(''),
    destination: new FormControl(''),
    numberOfStops: new FormControl(''),
    price: new FormControl(''),
    seatsAvailable: new FormControl(''),
    freeMeal: new FormControl(''),
    available: new FormControl(''),
  });

  constructor(private dialogRef: MatDialogRef<FlightAdminNewDialogComponent>,
    private bookingService: BookingService) { }

  ngOnInit(): void {
    this.getSource();
  }

  public closeDialog(): void {
    this.dialogRef.close();
  }

  public saveFlight() {
    let obj = {
      flightCode: this.addFlightForm.controls['flightCode'].value,
      airlineName: this.addFlightForm.controls['airlineName'].value,
      source: this.addFlightForm.controls['source'].value,
      price: this.addFlightForm.controls['price'].value,
      destination: this.addFlightForm.controls['destination'].value,
      numberOfStops: this.addFlightForm.controls['numberOfStops'].value,
      seatsAvailable: this.addFlightForm.controls['seatsAvailable'].value,
      freeMeal: this.addFlightForm.controls['freeMeal'].value,
      available: this.addFlightForm.controls['available'].value,
    }
    this.dialogRef.close(obj);
  }

  public getSource() {
    this.bookingService.getAirportCodes().subscribe(response => {
      this.sources = response;
    }, error => {
      console.log('Error occured!', error);
    })
  }

  public getDestination(source: string) {
    this.bookingService.getAirportCodesExceptSource(source).subscribe(response => {
      this.destinations = response;
    }, error => {
      console.log('Error occured!', error);
    })
  }

  onSourceChange(id: any) {
    this.getDestination(id);
  }

}
