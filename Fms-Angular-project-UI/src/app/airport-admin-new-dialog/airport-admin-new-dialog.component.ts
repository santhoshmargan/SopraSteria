import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDialogRef } from '@angular/material/dialog';

@Component({
  selector: 'app-airport-admin-new-dialog',
  templateUrl: './airport-admin-new-dialog.component.html',
  styleUrls: ['./airport-admin-new-dialog.component.scss']
})
export class AirportAdminNewDialogComponent implements OnInit {

  addAirportForm = new FormGroup({
    cityCode: new FormControl(''),
    cityName: new FormControl(''),
    countryCode: new FormControl(''),
    countryName: new FormControl(''),
    lat: new FormControl(''),
    lon: new FormControl(''),
    name: new FormControl(''),
    numAirports: new FormControl(''),
  });


  constructor(private dialogRef: MatDialogRef<AirportAdminNewDialogComponent>) { }

  ngOnInit(): void {
  }

  public closeDialog(): void {
    this.dialogRef.close();
  }

  public addAirport() {
    let obj = {
      cityCode: this.addAirportForm.controls['cityCode'].value,
      cityName: this.addAirportForm.controls['cityName'].value,
      countryCode: this.addAirportForm.controls['countryCode'].value,
      countryName: this.addAirportForm.controls['countryName'].value,
      lat: this.addAirportForm.controls['lat'].value,
      lon: this.addAirportForm.controls['lon'].value,
      name: this.addAirportForm.controls['name'].value,
      numAirports: this.addAirportForm.controls['numAirports'].value,
    }
    this.dialogRef.close(obj);
  }
  

}
