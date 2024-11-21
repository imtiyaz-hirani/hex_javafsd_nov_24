 
 import { NgFor } from '@angular/common';
import { Component, OnDestroy, OnInit  } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { UserService } from './service/user.service';

@Component({
  selector: 'app-root',
  imports: [ NgFor],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit,OnDestroy  {
   
   userData:any[]=[];
   
   constructor(private userService: UserService){ } //injected user service

  ngOnInit(): void {
    this.userData = this.userService.getUserData();
  }
  
  onDelete(userId:number){
     this.userData = this.userData.filter(u=>u.id !== userId)

  }
  ngOnDestroy(): void {
    throw new Error('Method not implemented.');
  }
}
