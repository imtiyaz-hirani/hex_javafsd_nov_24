import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class AuthService{
  
    signupApi='http://localhost:8081/auth/sign-up';

    constructor(private httpClient: HttpClient){}

    signUp(user: any) : Observable<any>{
        return this.httpClient.post(this.signupApi,user);
      }
}