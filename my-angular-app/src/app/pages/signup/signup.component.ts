import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-signup',
  imports: [FormsModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {

  name: string ="";
  username: string ="";
  password: string=""; 

  onSignUp(){
    console.log(this.name);
    console.log(this.username);
    console.log(this.password);
  }
}
