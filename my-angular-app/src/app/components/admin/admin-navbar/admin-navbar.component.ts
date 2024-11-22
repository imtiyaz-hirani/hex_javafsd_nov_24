import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-navbar',
  imports: [],
  templateUrl: './admin-navbar.component.html',
  styleUrl: './admin-navbar.component.css'
})
export class AdminNavbarComponent {
  name: any; 
  
  constructor(private router: Router){
    this.name = localStorage.getItem('name');
  }
  logout(){
      localStorage.clear();
      this.router.navigateByUrl('login?msg=you have successfully logged out')
  }
}
