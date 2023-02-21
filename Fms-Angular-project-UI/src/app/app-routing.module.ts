import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashboardComponent } from './admin-dashboard/admin-dashboard.component';
import { AirportAdminComponent } from './airport-admin/airport-admin.component';
import { BookingComponent } from './booking/booking.component';
import { FlightAdminComponent } from './flight-admin/flight-admin.component';
import { HomeComponent } from './home/home.component';
import { SigninComponent } from './signin/signin.component';
import { SignupComponent } from './signup/signup.component';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home' },
  { path: 'home', component: HomeComponent },
  { path: 'signin', component: SigninComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'bookings', component: BookingComponent },
  { path: 'admin', component: AdminDashboardComponent },
  { path: 'admin/flights', component: FlightAdminComponent },
  { path: 'admin/airports', component: AirportAdminComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
