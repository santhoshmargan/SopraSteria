import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { AvailableFlightsDialogComponent } from '../available-flights-dialog/available-flights-dialog.component';
import { BookingService } from '../services/booking.service';
import { MatDialog } from '@angular/material/dialog';
import { FlightService } from '../services/flight.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MyBookingDialogComponent } from '../my-booking-dialog/my-booking-dialog.component';

@Component({
  selector: 'app-booking',
  templateUrl: './booking.component.html',
  styleUrls: ['./booking.component.scss']
})
export class BookingComponent implements OnInit {

  roundTrip: boolean = false;

  public sources: any;

  public destinations: any;

  bookingForm = new FormGroup({
    source: new FormControl(''),
    destination: new FormControl(''),
    departureDate: new FormControl(''),
    returnDate: new FormControl(''),
    adults: new FormControl(''),
    childrens: new FormControl(''),
    infants: new FormControl('')
  });

  constructor(private bookingservice: BookingService,
    private dialog: MatDialog,
    private flightService: FlightService,
    private snackBar: MatSnackBar) { }

  ngOnInit(): void {
    this.bookingservice.getAirportCodes().subscribe(res => {
      this.sources = res;
    }, error => {
      console.log('could not get source', error);
    });
  }

  isRoundTrip(roundTrip: boolean) {
    this.roundTrip = roundTrip;
  }

  onSourceChange(source: any) {
    if (source.id) {
      this.bookingservice.getAirportCodesExcept(source.id).subscribe(res => {
        this.destinations = res;
      }, error => {
        console.log('could not get destination', error);
      });
    }
  }

  onSearch() {
    const source = this.bookingForm.controls['source'].value.code;
    const destination = this.bookingForm.controls['destination'].value.code;
    this.flightService.getFlights(source, destination).subscribe(response => {
      if (response.length) {
        const obj = {
          'bookingForm': this.bookingForm.value,
          'flights': response,
          'isRoundTrip': this.roundTrip
        }
        this.openAvailableFlightsDialog(obj);
      } else {
        this.openSnackBar('No flights available with entered criteria currently');
      }
    }, error => {
      console.log('Error occured!', error);
    }
    );
  }

  public openSnackBar(message: string): void {
    this.snackBar.open(message, '', {
      duration: 3000,
      panelClass: ['snack'],
    });
  }

  public openAvailableFlightsDialog(response: any): void {
    const dialogRef = this.dialog.open(AvailableFlightsDialogComponent, {
      panelClass: ['dialogClass'],
      data: response,
    });

    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        // console.log('obj', result);
        this.saveBooking(result);
      }
    });
  }

  public saveBooking(object: any) {
    this.bookingservice.saveBooking(object).subscribe(response => {
      this.openSnackBar('Booking saved successfully');
    }, error => {
      console.log('Error saving data', error);
      this.openSnackBar('Something went wrong, cannot save booking');
    })
  }

  public getMyBookings() {
    const id = sessionStorage.getItem('id');
    this.bookingservice.getUserBookings(id ? id : '0').subscribe(response => {
      if (response.length > 0) {
        this.openMyBookingsDialog(response);
      } else {
        this.openSnackBar('You do not have any booking yet.');
      }
    }, error => {
      console.log('error occured', error);
    })
  }


  public openMyBookingsDialog(response: any): void {
    const dialogRef = this.dialog.open(MyBookingDialogComponent, {
      panelClass: ['dialogClass'],
      data: response,
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        // console.log('obj', result);
        //this.saveBooking(result); 
      }
    });
  }


}
