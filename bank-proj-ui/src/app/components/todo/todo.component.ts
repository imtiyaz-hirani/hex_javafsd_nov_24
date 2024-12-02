import { Component } from '@angular/core';
import {userData} from '../../data/user-data'
import { NgFor } from '@angular/common';
import { UserService } from '../../services/user.service';
@Component({
  selector: 'app-todo',
  imports: [NgFor],
  templateUrl: './todo.component.html',
  styleUrl: './todo.component.css'
})
export class TodoComponent {
  data:any[] = []
  page:number=0;
  size:number=7;
  totalElements: number = 0;
  pageArray:any[] =[];

  constructor(private userService: UserService){
    this.getData();
   
   }

   getData(){
    this.userService.getUserData(this.page,this.size).subscribe({
      next:(resp)=>{
        this.data = resp.content; 
        this.totalElements = resp.totalElements;
        let totalPages = this.totalElements / this.size;
        let i=1; 
        this.pageArray = [];
        while(totalPages > 0){
          this.pageArray.push(i)
          totalPages = totalPages - 1;
          i++;
        }
        console.log(this.pageArray)
      },
      error:()=>{}
    })
   }
   prev(){
     if(this.page >0){
      this.page = this.page - 1 
      this.getData() 
    }
        
   }

   next(){
    this.page = this.page + 1 
    this.getData()

   }

   onClick(i:number){
      this.page = i
      this.getData()
   }
}
