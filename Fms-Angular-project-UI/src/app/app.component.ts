import { Component, OnInit } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  title: string = 'SSI Flight Management';

  isLoggedIn: boolean = false;

   constructor(private authService: AuthService) {
    this.authService.isLoggedIn.subscribe(res=>{
      this.isLoggedIn = res;
    });
   }

  ngOnInit(): void {
     this.authService.isLoggedIn.subscribe(res=>{
      this.isLoggedIn = res;
    });
   }

   username(){
     return sessionStorage.getItem('username');
   }

  logout() {
    this.authService.logout();
  }
}
