import { Component, OnDestroy, OnInit } from '@angular/core';
import { TodoService } from '../../service/todo.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-todo-list',
  imports: [NgFor],
  templateUrl: './todo-list.component.html',
  styleUrl: './todo-list.component.css'
})
export class TodoListComponent implements OnInit, OnDestroy{
  
  todos: any[]=[];
  errorMsg: string | undefined;
  constructor(private todoService: TodoService){}
  ngOnInit(): void {
     this.todoService.getAllTodos().subscribe({
      next:(data)=>{
        this.todos = data;
      },
      error:(err)=>{
        this.errorMsg = err.message; 
      }
     })
  }

  ngOnDestroy(): void {
      
  }
}
