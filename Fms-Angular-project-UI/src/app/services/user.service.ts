import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Auth } from '../models/auth';
import { Users } from '../models/users';
import { EndpointService } from './endpoint.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient, private endpoint: EndpointService) { }

  public getUsers(): Observable<Users[]> {
    const uri = this.endpoint.users();
    return this.http.get<Users[]>(uri);
  }

  public addUser(user: Users): Observable<Users> {
    const uri = this.endpoint.users();
    return this.http.post<Users>(uri, user);
  }

  public updateUser(user: Users): Observable<Users> {
    const uri = this.endpoint.user(user.id);
    return this.http.put<Users>(uri, user);
  }

  public deleteUser(id: number): Observable<any> {
    const uri = this.endpoint.user(id);
    return this.http.delete<any>(uri);
  }

  public getUser(id: number): Observable<Users> {
    const uri = this.endpoint.user(id);
    return this.http.get<Users>(uri);
  }

  public signin(userCredentials: Auth): Observable<Users> {
    const uri = this.endpoint.login();
    return this.http.post<Users>(uri, userCredentials);
  }

}
