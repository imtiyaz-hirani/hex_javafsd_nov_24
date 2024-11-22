import { Component } from '@angular/core';
import { LoginHeaderComponent } from "../../components/login-header/login-header.component";
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-auth-page',
  imports: [LoginHeaderComponent, RouterOutlet],
  templateUrl: './auth-page.component.html',
  styleUrl: './auth-page.component.css'
})
export class AuthPageComponent {

}
