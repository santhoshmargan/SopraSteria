import { Injectable } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { BehaviorSubject, Observable, of } from 'rxjs';
import { UserService } from './user.service';
import { Auth } from '../models/auth'

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loggedIn: BehaviorSubject<boolean> = new BehaviorSubject<boolean>(false);

  get isLoggedIn() {
    return this.loggedIn.asObservable();
  }

  constructor(private userService: UserService,
    private router: Router,
    private snackBar: MatSnackBar) { }

  public login(loginFormValue: Auth): Observable<boolean> {
    this.userService.signin(loginFormValue).subscribe(res => {
      sessionStorage.setItem("id", res.id + '');
      sessionStorage.setItem("username", res.username);
      sessionStorage.setItem("password", res.password);
      sessionStorage.setItem("designation", res.designation);
      sessionStorage.setItem("email", res.email);
      sessionStorage.setItem("isAuthenticated", "true");
      this.loggedIn.next(true);
      if (res.designation.toLowerCase() === 'user') {
        this.router.navigate(['/bookings']);
      } else if (res.designation.toLowerCase() === 'admin') {
        this.router.navigate(['/admin']);
      }
      return of(true);
    }, error => {
      this.router.navigate(['/home']);
      // this.openSnackBar("User not found");
      console.log("error", error);
    });
    return of(false);
  }



  public logout() {
    sessionStorage.removeItem("id");
    sessionStorage.removeItem("username");
    sessionStorage.removeItem("password");
    sessionStorage.removeItem("designation");
    sessionStorage.removeItem("email");
    sessionStorage.removeItem("isAuthenticated");
    this.loggedIn.next(false);
    this.router.navigate(['/home']);
  }

  public openSnackBar(message: string): void {
    this.snackBar.open(message, '', {
      duration: 2000,
      panelClass: ['snack'],
    });
  }
}
