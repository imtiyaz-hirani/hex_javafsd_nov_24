import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class TodoService{

    getAllTodoApi='https://jsonplaceholder.typicode.com/todos'
    constructor(private httpClient: HttpClient){}

    getAllTodos() : Observable<any>{
        return this.httpClient.get(this.getAllTodoApi);
    }
}