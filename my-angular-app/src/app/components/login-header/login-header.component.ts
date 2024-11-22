import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-header',
  imports: [],
  templateUrl: './login-header.component.html',
  styleUrl: './login-header.component.css'
})
export class LoginHeaderComponent {

  constructor(private router: Router){}
  navigateToSignUp(){
    this.router.navigateByUrl("/sign-up");
  }
}
