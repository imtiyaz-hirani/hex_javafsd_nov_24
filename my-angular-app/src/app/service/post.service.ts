import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class PostService{

    getAllApi = 'https://jsonplaceholder.typicode.com/posts';
    constructor(private httpClient: HttpClient){ } //inject httpClient 

    /** when this method is called, i will return the container */
    getAllPost() : Observable<any>{  
       return this.httpClient.get(this.getAllApi);
    }
}