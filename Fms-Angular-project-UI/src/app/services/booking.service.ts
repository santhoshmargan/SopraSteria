import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Airports } from '../models/airports';
import { EndpointService } from './endpoint.service';

@Injectable({
  providedIn: 'root'
})
export class BookingService {

  constructor(private http: HttpClient, private endpoint: EndpointService) { }

  public getAirportCodes(): Observable<Airports[]> {
    const uri = this.endpoint.airportCodes();
    return this.http.get<Airports[]>(uri);
  }

  public getAirportCodesExcept(id: number): Observable<Airports[]> {
    const uri = this.endpoint.airportCodesExcept(id);
    return this.http.get<Airports[]>(uri);
  }

  public getAirportCodesExceptSource(source: string): Observable<Airports[]> {
    const uri = this.endpoint.airportCodesExceptSource(source);
    return this.http.get<Airports[]>(uri);
  }

  public saveBooking(booking:any) : Observable<any>{
    const uri = this.endpoint.booking();
    return this.http.post<any>(uri, booking);
  }

  public getUserBookings(id:string) : Observable<any>{
    const uri = this.endpoint.userBookings(id);
    return this.http.get<any>(uri);
  }

  public deleteBooking(id:any) : Observable<any>{
    const uri = this.endpoint.bookingWithId(id);
    return this.http.delete<any>(uri);
  }

  public deleteAirport(id:any) : Observable<any>{
    const uri = this.endpoint.deleteAirport(id);
    return this.http.delete<any>(uri);
  }

  public saveAirport(obj:any): Observable<any>{
    const uri = this.endpoint.airport();
    return this.http.post<any>(uri,obj);
  }

  public updateAirport(obj:any,id:any): Observable<any>{
    const uri = this.endpoint.updateAirport(id);
    return this.http.put<any>(uri,obj);
  }

}
