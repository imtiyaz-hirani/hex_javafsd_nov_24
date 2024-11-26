import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({providedIn: 'root'})
export class AdminService{
   

    constructor(private httpClient: HttpClient){}

    private getAllDepartmentsApi = 'http://localhost:8081/department/all'
    private getAllJobTitlesApi='http://localhost:8081/job-title/all'
    private postExecutiveApi='http://localhost:8081/executive/add'
    private userStatApi = 'http://localhost:8081/api/users-stat';

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

    public postExecutive(obj: any) :Observable<any>{
      let postObj = {
        name: obj.name,
        contact: obj.contact,
        department: obj.department,
        jobTitle: obj.jobTitle,
        user:{
     	      username: obj.username,
     	      password: obj.password,
        }
      };

      const httpOptions = {
        headers: new HttpHeaders({
           Authorization: 'Bearer '+ localStorage.getItem('token')
        })
      };
       return this.httpClient.post(this.postExecutiveApi,postObj,httpOptions)
    }


    public getUserStat(): Observable<any>{
      const httpOptions = {
        headers: new HttpHeaders({
           Authorization: 'Bearer '+ localStorage.getItem('token')
        })
      };
      return this.httpClient.get(this.userStatApi,httpOptions);
    }
}