import { Injectable } from '@angular/core';
import { userData } from '../data/user-data';

@Injectable({
  providedIn: 'root'
})
export class UserService {

   userData: any[];

   constructor(){
    this.userData =  userData;
   }

   public getUserData(){
      return this.userData; 
   }
}
