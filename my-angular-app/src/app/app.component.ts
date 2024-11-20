 
import { NgIf } from '@angular/common';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet,NgIf],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit, OnDestroy{
  /** Declaration  */
  x:any; 
  y:any; 
  msg:any;
  employee:any;
  data: any; 
  isLoggedIn:boolean=false; 

  constructor(){
    console.log('constructor gets called...');
  }

  /** Initialization  */
  ngOnInit(): void {
    console.log('ng-oninit gets called...')
    this.x = 10;
    this.y = 20;
    this.msg="";
    this.sayHello();
    this.employee = {
      name: 'harry potter',
      city: 'london',
      address: ""
    };
  }

  /**Functions  */
  sayHello(){
    this.msg = "Hello User!!!"; 
  }
  /** if show address button is clcked, call this function */
  showAddress(){
    this.employee.address ="101 Kingston lane, thames TW31SE";
  }
 
  loadData(){
    this.data="this is sample data";
  }
  ngOnDestroy(): void {
    console.log('on-destroy gets called...')

  }
}
