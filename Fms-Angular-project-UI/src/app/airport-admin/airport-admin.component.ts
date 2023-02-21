import { Component, ViewChild } from '@angular/core';
import { Location } from '@angular/common'
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { BookingService } from '../services/booking.service';
import { AirportAdminEditDialogComponent } from '../airport-admin-edit-dialog/airport-admin-edit-dialog.component';
import { MatDialog } from '@angular/material/dialog';
import { AirportAdminNewDialogComponent } from '../airport-admin-new-dialog/airport-admin-new-dialog.component';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-airport-admin',
  templateUrl: './airport-admin.component.html',
  styleUrls: ['./airport-admin.component.scss']
})
export class AirportAdminComponent {
  displayedColumns: string[] = ["id", "cityCode", "cityName", "countryCode", "countryName", 'lat', "lon", 'name', 'numAirports', 'actions'];
  dataSource: any = new MatTableDataSource();
  @ViewChild(MatPaginator) paginator: any;
  filter:string = '';

  constructor(private location: Location,
    private bookingService: BookingService,
    private dialog: MatDialog,
    private snackBar: MatSnackBar) {
  }

  ngOnInit(): void {
    this.getAllAirports();
  }


  back(): void {
    this.location.back()
  }

  addAirport() {
    const dialogRef = this.dialog.open(AirportAdminNewDialogComponent, {
      panelClass: ['dialogClass']
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        console.log('obj', result);
        this.saveAirport(result);
      }
    });
  }

  public saveAirport(result: any) {
    this.bookingService.saveAirport(result).subscribe(response => {
      console.log('response:',response);
      this.getAllAirports();
      this.openSnackBar('Airport saved sucessfully!')
    }, error => {
      console.log('error occured', error);
    })
  }

  onEditClick(data: any) {
    this.openEditAirportDialog(data);
  }

  public openEditAirportDialog(response: any): void {
    const dialogRef = this.dialog.open(AirportAdminEditDialogComponent, {
      panelClass: ['dialogClass'],
      data: response,
    });
    dialogRef.afterClosed().subscribe((result: any) => {
      if (result) {
        console.log('obj', result);
        this.updateAirport(result);
      }
    });
  }

  public updateAirport(result: any) {
    this.bookingService.updateAirport(result, result.id).subscribe(response => {
      console.log('response', response);
      this.getAllAirports();
      this.openSnackBar('Airport updated sucessfully!')
    }, error => {
      console.log('error occured', error);
    })
  }

  public onDeleteClick(id: any) {
    this.bookingService.deleteAirport(id).subscribe(response => {
      console.log('response', response);
      this.getAllAirports();
      this.openSnackBar('Airport deleted!');
    }, error => {
      this.openSnackBar('Cannot delete airport');
      console.log('error occured', error);
    })
  }


  public openSnackBar(message: string): void {
    this.snackBar.open(message, '', {
      duration: 3000,
      panelClass: ['snack'],
    });
  }


  public getAllAirports(){
    this.bookingService.getAirportCodes().subscribe(response => {
      this.dataSource = new MatTableDataSource(response);
      this.dataSource.paginator = this.paginator;
    })
  }

  applyFilter() {
    console.log('val::',this.filter);
    this.dataSource.filter = this.filter.trim().toLowerCase();
    console.log(this.dataSource.filter);
    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }

}
