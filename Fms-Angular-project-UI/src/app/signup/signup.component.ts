import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Users } from '../models/users';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  User: any = ['Admin', 'User'];

  signupForm = new FormGroup({
    username: new FormControl(''),
    email: new FormControl(''),
    phoneNumber: new FormControl(''),
    password: new FormControl(''),
    confirmPassword: new FormControl(''),
    designation: new FormControl('')
  });

  constructor(private userService: UserService,
    private snackBar: MatSnackBar,
    private router: Router) { }

  ngOnInit(): void {
  }

  onRegister() {
    console.log('sign up form',this.signupForm.value as Users)
    this.userService.addUser(this.signupForm.value as Users).subscribe(res => {
      this.openSnackBar("Registered successfully");
      this.router.navigate(['/signin']);
    }, error => {
      this.openSnackBar("Cannot add user");
      console.log("Can't add user", error);
    })
  }

  hasError(event: any) {

  }

  getNumber(event: any) {

  }

  telInputObject(event: any) {

  }

  onCountryChange(event: any) {

  }

  public openSnackBar(message: string): void {
    this.snackBar.open(message, '', {
      duration: 2000,
      panelClass: ['snack'],
    });
  }

}
