import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EndpointService {

  public readonly contextPath: string = './server';

  //---------------------------------USER----------------------------------------------

  public readonly users = (): string => `${this.contextPath}/users/addUser`;

  public readonly user = (id: number): string => `${this.contextPath}/users/${id}`;

  public readonly login = (): string => `${this.contextPath}/users/auth`;

  //---------------------------------AIRPORT----------------------------------------------

  public readonly airportCodes = (): string => `${this.contextPath}/airports/allAirports`;

  public readonly airportCodesExcept = (id: number): string => `${this.contextPath}/airports/destination/${id}`

  public readonly deleteAirport = (id: number): string => `${this.contextPath}/airports/deleteAirport/${id}`

  public readonly updateAirport = (airport: any): string => `${this.contextPath}/airports/updateAirport`

  public readonly airport = (): string => `${this.contextPath}/airports/saveAirport`;

  public readonly airportCodesExceptSource = (source: string): string => `${this.contextPath}/airports/destinations/${source}`

  //-----------------------------------FLIGHT---------------------------------------------

  public readonly searchFlight = (source: string, destination: string): string => `${this.contextPath}/flights/${source}/${destination}`;

  public readonly allFlight = (): string => `${this.contextPath}/flights/viewAllFlight`;

  public readonly addFlight = (): string => `${this.contextPath}/flights/addFlight`;

  public readonly deleteFlight = (id: any): string => `${this.contextPath}/flights/deleteById/${id}`;

  public readonly updateFlight = (flight: any): string => `${this.contextPath}/flights/updateFlight`;

  //-----------------------------------BOOKINGS------------------------------------------
  public readonly booking = (): string => `${this.contextPath}/booking/saveBooking`

  public readonly userBookings = (id: string) => `${this.contextPath}/bookings/user/${id}`;

  public readonly bookingWithId = (id: any): string => `${this.contextPath}/bookings/${id}`

}
