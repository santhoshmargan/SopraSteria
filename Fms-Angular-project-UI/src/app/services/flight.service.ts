import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Flight } from '../models/flight';
import { EndpointService } from './endpoint.service';

@Injectable({
  providedIn: 'root'
})
export class FlightService {

  constructor(private http: HttpClient, private endpoint: EndpointService) { }

  getFlights(source: string, destination: string): Observable<Flight[]> {
    const uri = this.endpoint.searchFlight(source, destination);
    return this.http.get<Flight[]>(uri);
  }

  getFlightDetails() {
    const uri = this.endpoint.allFlight();
    return this.http.get<Flight[]>(uri);
  }

  saveFlight(flight: any) {
    const uri = this.endpoint.addFlight();
    return this.http.post<any>(uri, flight);
  }

  updateFlight(flight: any, id: any) {
    const uri = this.endpoint.updateFlight(id);
    return this.http.put<any>(uri, flight);
  }

  deleteFlight( id: any) {
    const uri = this.endpoint.deleteFlight(id);
    return this.http.delete<any>(uri);
  }
}
