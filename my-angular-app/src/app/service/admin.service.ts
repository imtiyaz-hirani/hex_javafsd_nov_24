import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({providedIn: 'root'})
export class AdminService{

    constructor(private httpClient: HttpClient){}

    private getAllDepartmentsApi = 'http://localhost:8081/department/all'
    private getAllJobTitlesApi='http://localhost:8081/job-title/all'

    public getAllDepartments(): Observable<any>{
        const httpOptions = {
            headers: new HttpHeaders({
               Authorization: 'Bearer '+ localStorage.getItem('token')
            })
          };
        return this.httpClient.get(this.getAllDepartmentsApi, httpOptions);
    }

    public getAllJobTitles(): Observable<any>{
        const httpOptions = {
            headers: new HttpHeaders({
               Authorization: 'Bearer '+ localStorage.getItem('token')
            })
          };
        return this.httpClient.get(this.getAllJobTitlesApi,httpOptions);
    }
}