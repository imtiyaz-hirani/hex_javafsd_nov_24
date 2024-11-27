import { NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  imports: [FormsModule,NgIf],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string="";
  password: string="";
  successMsg: string | undefined;
  errorMsg:string | undefined;
  msg: string | undefined; 

  constructor(private router: Router){}
  onLogin(){
    localStorage.setItem('username','harry@gmail.com'); 
    this.router.navigateByUrl('/dashboard');
  }

}
