import { SelectionModel } from '@angular/cdk/collections';
import { DatePipe } from '@angular/common';
import { Component, Inject, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Flight } from '../models/flight';

@Component({
  selector: 'app-available-flights-dialog',
  templateUrl: './available-flights-dialog.component.html',
  styleUrls: ['./available-flights-dialog.component.scss']
})
export class AvailableFlightsDialogComponent implements OnInit {

  dataSource: any;

  displayedColumns: string[] = ['select', 'id', 'airlineName', 'flightCode', 'freeMeal', 'numberOfStops', 'price'];

  selection = new SelectionModel<Flight>(true, []);

  @ViewChild(MatPaginator) paginator: any;

  availableFlights = new FormGroup({
    source: new FormControl({ value: '', disabled: true }),
    destination: new FormControl({ value: '', disabled: true }),
    departureDate: new FormControl({ value: '', disabled: true }),
    returnDate: new FormControl({ value: '', disabled: true }),
    adults: new FormControl({ value: '', disabled: true }),
    childrens: new FormControl({ value: '', disabled: true }),
    infants: new FormControl({ value: '', disabled: true }),
    isRoundTrip: new FormControl({ value: '', disabled: true }),
  });

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }


  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
    private dialogRef: MatDialogRef<AvailableFlightsDialogComponent>) {
    this.dataSource = new MatTableDataSource<Flight>(data?.flights);
    this.availableFlights.setValue({
      source: data.bookingForm.source.code,
      destination: data.bookingForm.destination.code,
      departureDate: this.formattedDate(new Date(data.bookingForm.departureDate)),
      returnDate: data.bookingForm?.returnDate ? this.formattedDate(new Date(data.bookingForm.returnDate)) : '',
      adults: data.bookingForm.adults,
      childrens: data.bookingForm.childrens,
      infants: data.bookingForm.infants,
      isRoundTrip: data.isRoundTrip
    })
  }


  formattedDate(d: Date) {
    let month = String(d.getMonth() + 1);
    let day = String(d.getDate());
    const year = String(d.getFullYear());
    if (month.length < 2) month = '0' + month;
    if (day.length < 2) day = '0' + day;
    return `${day}/${month}/${year}`;
  }

  ngOnInit(): void {
  }

  public closeDialog(): void {
    this.dialogRef.close();
  }

  public addBooking() {
    const flightId = this.selection.selected[0].id;
    const userId = sessionStorage.getItem('id');
    let obj = {
      departureDate: this.availableFlights.controls['departureDate'].value,
      returnDate: this.availableFlights.controls['returnDate'].value ? this.availableFlights.controls['returnDate'].value : null,
      adults: this.availableFlights.controls['adults'].value,
      children: this.availableFlights.controls['childrens'].value,
      infants: this.availableFlights.controls['infants'].value,
      isRoundTrip: this.availableFlights.controls['isRoundTrip'].value,
      userId: userId,
      flightId: flightId
    }
    this.dialogRef.close(obj);
  }

}
