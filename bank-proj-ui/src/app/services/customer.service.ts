import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class CustomerService{
    
    private getAllAccountsApi= 'http://localhost:8081/api/account/customer'
    private getCustomerDetailsByAccountAPi='http://localhost:8081/api/customer/account'
    private postTransactionApi = 'http://localhost:8081/api/transaction/add';
    private getCustomerDetailsByUsernameApi='http://localhost:8081/api/customer/details';
    private customerUpdateAPi='http://localhost:8081/api/customer/update'

    constructor(private httpClient: HttpClient){}

    public getAllAccounts(username: any): Observable<any>{
        return this.httpClient.get(this.getAllAccountsApi + '?username=' + username)
    }

    public getCustomerDetailsByAccountNo(accountNum: any) :Observable<any>{
        return this.httpClient.get(this.getCustomerDetailsByAccountAPi + '?accountNumber=' + accountNum);
      }

    public  postTransaction(obj: any) :Observable<any>{
        return this.httpClient.post(this.postTransactionApi,obj)
    }
   
    public getCustomerDetailsByUsername(username: any) : Observable<any>{
         return this.httpClient.get(this.getCustomerDetailsByUsernameApi + '?username=' + username)
    }

    public updateProfile(customer: any) : Observable<any>{
         return this.httpClient.post(this.customerUpdateAPi,customer);
      }
}