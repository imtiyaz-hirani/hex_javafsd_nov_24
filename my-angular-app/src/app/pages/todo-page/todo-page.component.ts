import { Component } from '@angular/core';
import { TodoListComponent } from "../../components/todo-list/todo-list.component";

@Component({
  selector: 'app-todo-page',
  imports: [TodoListComponent],
  templateUrl: './todo-page.component.html',
  styleUrl: './todo-page.component.css'
})
export class TodoPageComponent {

}
