import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { BookingService } from '../services/booking.service';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-flight-admin-edit-dialog',
  templateUrl: './flight-admin-edit-dialog.component.html',
  styleUrls: ['./flight-admin-edit-dialog.component.scss']
})
export class FlightAdminEditDialogComponent implements OnInit {

  sources: any;
  destinations: any;

  editFlightForm = new FormGroup({
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

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
    private dialogRef: MatDialogRef<FlightAdminEditDialogComponent>,
    private bookingService: BookingService) {
    this.getDestination(data.source);
    this.editFlightForm.setValue({
      flightCode: data.flightCode,
      airlineName: data.airlineName,
      source: data.source,
      destination: data.destination,
      numberOfStops: data.numberOfStops,
      price: data.price,
      seatsAvailable: data.seatsAvailable,
      freeMeal: data.freeMeal,
      available: data.available,
    })
  }

  ngOnInit(): void {
    this.getSource();
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

  public closeDialog(): void {
    this.dialogRef.close();
  }

  public editFlight() {
    let obj = {
      id: this.data.id,
      flightCode: this.editFlightForm.controls['flightCode'].value,
      airlineName: this.editFlightForm.controls['airlineName'].value,
      source: this.editFlightForm.controls['source'].value,
      price: this.editFlightForm.controls['price'].value,
      destination: this.editFlightForm.controls['destination'].value,
      numberOfStops: this.editFlightForm.controls['numberOfStops'].value,
      seatsAvailable: this.editFlightForm.controls['seatsAvailable'].value,
      freeMeal: this.editFlightForm.controls['freeMeal'].value,
      available: this.editFlightForm.controls['available'].value,
    }
    this.dialogRef.close(obj);
  }

  onSourceChange(id: any) {
    this.getDestination(id);
  }

}
