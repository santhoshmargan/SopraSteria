import { APP_INITIALIZER, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AngularMaterialModule } from './angular-material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';
import { FlexLayoutModule } from "@angular/flex-layout";
import { BookingComponent } from './booking/booking.component';
import { HttpClientModule } from '@angular/common/http';
import { Ng2TelInputModule } from 'ng2-tel-input';
import { appInitializer } from './services/app.init';
import { AuthService } from './services/auth.service';
import { AvailableFlightsDialogComponent } from './available-flights-dialog/available-flights-dialog.component';
import { MyBookingDialogComponent } from './my-booking-dialog/my-booking-dialog.component';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { FlightAdminComponent } from './flight-admin/flight-admin.component';
import { AirportAdminComponent } from './airport-admin/airport-admin.component';
import { AirportAdminEditDialogComponent } from './airport-admin-edit-dialog/airport-admin-edit-dialog.component';
import { AirportAdminNewDialogComponent } from './airport-admin-new-dialog/airport-admin-new-dialog.component';
import { FlightAdminEditDialogComponent } from './flight-admin-edit-dialog/flight-admin-edit-dialog.component';
import { FlightAdminNewDialogComponent } from './flight-admin-new-dialog/flight-admin-new-dialog.component';
import { HomeComponent } from './home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    SigninComponent,
    SignupComponent,
    BookingComponent,
    AvailableFlightsDialogComponent,
    MyBookingDialogComponent,
    AdminDashboardComponent,
    FlightAdminComponent,
    AirportAdminComponent,
    AirportAdminEditDialogComponent,
    AirportAdminNewDialogComponent,
    FlightAdminEditDialogComponent,
    FlightAdminNewDialogComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AngularMaterialModule,
    FlexLayoutModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    Ng2TelInputModule
  ],
  providers: [
    { provide: APP_INITIALIZER, useFactory: appInitializer, multi: true, deps: [AuthService] },
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
