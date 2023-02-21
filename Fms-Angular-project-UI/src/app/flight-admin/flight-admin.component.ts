import { Location } from '@angular/common';
import { Component, OnInit, ViewChild } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { MatPaginator } from '@angular/material/paginator';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MatTableDataSource } from '@angular/material/table';
import { FlightAdminEditDialogComponent } from '../flight-admin-edit-dialog/flight-admin-edit-dialog.component';
import { FlightAdminNewDialogComponent } from '../flight-admin-new-dialog/flight-admin-new-dialog.component';
import { FlightService } from '../services/flight.service';

@Component({
  selector: 'app-flight-admin',
  templateUrl: './flight-admin.component.html',
  styleUrls: ['./flight-admin.component.scss']
})
export class FlightAdminComponent implements OnInit {

  filter: string = '';
  displayedColumns: string[] = ["id", "airlineName", "available", 'source', "destination", "flightCode", 'freeMeal', "numberOfStops", 'price', 'seatsAvailable', 'actions'];
  dataSource: any = new MatTableDataSource();
  @ViewChild(MatPaginator) paginator: any;

  constructor(private location: Location,
    private flightService: FlightService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.getFlightDetails();
  }

  getFlightDetails(){
    this.flightService.getFlightDetails().subscribe(response => {
      this.dataSource = new MatTableDataSource(response);
      this.dataSource.paginator = this.paginator;
    })
  }


  back(): void {
    this.location.back()
  }

  applyFilter() {
    this.dataSource.filter = this.filter.trim().toLowerCase();
    console.log(this.dataSource.filter);
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

  addFlight() {
    this.openAddAirportDialog();
  }

  onEditClick(data: any) {
    this.openEditAirportDialog(data);
  }

  public openEditAirportDialog(response: any): void {
    console.log('response', response)
    const dialogRef = this.dialog.open(FlightAdminEditDialogComponent, {
      panelClass: ['dialogClass'],
      data: response,
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        console.log('obj', result);
        this.updateFlight(result);
      }
    });
  }

  openAddAirportDialog() {
    const dialogRef = this.dialog.open(FlightAdminNewDialogComponent, {
      panelClass: ['dialogClass'],
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        console.log('obj', result);
        this.saveFlight(result);
      }
    });
  }

  public saveFlight(result: any) {
    this.flightService.saveFlight(result).subscribe(response => {
      this.getFlightDetails();
      this.openSnackBar('Flight saved');
    }, error => {
      this.openSnackBar('Error saving flight');
      console.log('error', error);
    })
  }

  public updateFlight(result: any) {
    this.flightService.updateFlight(result, result.id).subscribe(response => {
      this.getFlightDetails();
      this.openSnackBar('Flight updated');
    }, error => {
      this.openSnackBar('Error updating flight');
      console.log('error', error);
    })
  }

  onDeleteClick(id: any) {
    console.log('id++++++++++++++++',id)
    this.flightService.deleteFlight(id).subscribe(resp => {
      this.getFlightDetails();
      this.openSnackBar('Flight deleted');
    }, error => {
      this.openSnackBar('Error deleting flight');
    })
  }

  public openSnackBar(message: string): void {
    this.snackBar.open(message, '', {
      duration: 3000,
      panelClass: ['snack'],
    });
  }


}