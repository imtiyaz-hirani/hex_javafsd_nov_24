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
  todosCopy: any[] =[];
  errorMsg: string | undefined;
  numComplete: number = 0;
  numInComplete: number = 0;
  numTotal: number =0;

  constructor(private todoService: TodoService){}
  ngOnInit(): void {
     this.todoService.getAllTodos().subscribe({
      next:(data)=>{
        this.todos = data;
        this.todosCopy = data;
        this.todos = this.todos.slice(0,20);
        this.todosCopy =this.todosCopy.slice(0,20);
        //calculate total 
        this.numTotal = this.todos.length;
        this.numComplete = this.todos.filter(t=>t.completed === true).length;
        this.numInComplete = this.todos.filter(t=>t.completed === false).length;
      },
      error:(err)=>{
        this.errorMsg = err.message; 
      }
     })
  }

  filterTodo(str:string){
    switch(str){
      case 'complete':
        this.todos = this.todosCopy;
        this.todos = this.todos.filter(t=>t.completed === true);
        break; 
      case 'in-complete':
        this.todos = this.todosCopy;
        this.todos = this.todos.filter(t=>t.completed === false);
        break;
      case 'reset':
        this.todos = this.todosCopy;
        break; 
    }
  }
  ngOnDestroy(): void {
      
  }
}
