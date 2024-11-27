import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class CustomerService{
    
 
    private getAllAccountsApi= 'http://localhost:8081/api/account/customer'
    private getCustomerDetailsByAccountAPi='http://localhost:8081/api/customer/account'

    constructor(private httpClient: HttpClient){}

    public getAllAccounts(username: any): Observable<any>{
        return this.httpClient.get(this.getAllAccountsApi + '?username=' + username)
    }

    public getCustomerDetailsByAccountNo(accountNum: any) :Observable<any>{
         return this.httpClient.get(this.getCustomerDetailsByAccountAPi + '?accountNumber=' + accountNum);
      }
}