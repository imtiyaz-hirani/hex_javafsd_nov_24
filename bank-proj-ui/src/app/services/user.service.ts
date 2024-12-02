import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn:'root'
})
export class UserService{

    private getUserDataApi='http://localhost:8081/api/user-details/all'
    constructor(private httpClient: HttpClient){}

    public getUserData(page:number, size: number): Observable<any>{
       return this.httpClient.get(this.getUserDataApi + '?page='+page + '&size='+size);
    }
}