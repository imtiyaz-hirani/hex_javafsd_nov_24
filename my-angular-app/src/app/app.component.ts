 
 import { NgFor } from '@angular/common';
import { Component, OnDestroy, OnInit  } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserService } from './service/user.service';
import { NavbarComponent } from "./components/navbar/navbar.component";
import { LoginHeaderComponent } from "./components/login-header/login-header.component";
import { UserListComponent } from "./components/user-list/user-list.component";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, NavbarComponent, LoginHeaderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent{
  
}
