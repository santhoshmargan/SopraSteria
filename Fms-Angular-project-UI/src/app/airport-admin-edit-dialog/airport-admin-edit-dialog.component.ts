import { Component, Inject, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-airport-admin-edit-dialog',
  templateUrl: './airport-admin-edit-dialog.component.html',
  styleUrls: ['./airport-admin-edit-dialog.component.scss']
})
export class AirportAdminEditDialogComponent implements OnInit {

  editAirportForm = new FormGroup({
    cityCode: new FormControl(''),
    cityName: new FormControl(''),
    countryCode: new FormControl(''),
    countryName: new FormControl(''),
    lat: new FormControl(''),
    lon: new FormControl(''),
    name: new FormControl(''),
    numAirports: new FormControl(''),
  });

  constructor(@Inject(MAT_DIALOG_DATA) public data: any,
    private dialogRef: MatDialogRef<AirportAdminEditDialogComponent>) {
    this.editAirportForm.setValue({
      cityCode: data.cityCode,
      cityName: data.cityName,
      countryCode: data.countryCode,
      countryName: data.countryName,
      lat: data.lat,
      lon: data.lon,
      name: data.name,
      numAirports: data.numAirports
    })
  }

  ngOnInit(): void {
  }

  public closeDialog(): void {
    this.dialogRef.close();
  }

  public editAirport() {
    let obj = {
      id: this.data.id,
      cityCode: this.editAirportForm.controls['cityCode'].value,
      cityName: this.editAirportForm.controls['cityName'].value,
      countryCode: this.editAirportForm.controls['countryCode'].value,
      countryName: this.editAirportForm.controls['countryName'].value,
      lat: this.editAirportForm.controls['lat'].value,
      lon: this.editAirportForm.controls['lon'].value,
      name: this.editAirportForm.controls['name'].value,
      numAirports: this.editAirportForm.controls['numAirports'].value,
    }
    this.dialogRef.close(obj);
  }
  

}
