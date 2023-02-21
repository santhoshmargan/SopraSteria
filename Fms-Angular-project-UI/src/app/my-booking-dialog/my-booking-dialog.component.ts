import { Component, Inject, OnInit } from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { BookingService } from '../services/booking.service';

@Component({
  selector: 'app-my-booking-dialog',
  templateUrl: './my-booking-dialog.component.html',
  styleUrls: ['./my-booking-dialog.component.scss']
})
export class MyBookingDialogComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
  private bookingService: BookingService,
  private snackBar: MatSnackBar,
  private dialogRef: MatDialogRef<MyBookingDialogComponent>) {
    this.dataSource = new MatTableDataSource(data);
    console.log('data',data);
   }
  displayedColumns: string[] = [ 'id','airlineName','departureDate','returnDate','freeMeal','numberOfStops','price','action'];
  dataSource: any;
  
  ngOnInit(): void {
  }

  public deleteBooking(id:any){
    this.bookingService.deleteBooking(id).subscribe(response=>{
      const identifier = sessionStorage.getItem('id');
      this.bookingService.getUserBookings(identifier?identifier:'0').subscribe(resp=>{
        this.dataSource = new MatTableDataSource(resp);
        this.openSnackBar('Booking cancelled');
      },error=>{
        console.log('error',error);
        this.openSnackBar('Something went wrong try again');
      })
    },error=>{
      console.log('error',error)
      this.openSnackBar('Cannot cancel booking');
    })
  }

  public openSnackBar(message: string): void {
    this.snackBar.open(message, '', {
      duration: 2000,
      panelClass: ['snack'],
    });
  }

  public closeDialog(): void {
    this.dialogRef.close();
  }


}
