import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class ProductService{
    
    
    private getAllProductsApi = 'http://localhost:8081/api/product/all'
    private getDetailsByIdApi = 'http://localhost:8081/product/one/'

    constructor(private httpClient: HttpClient){}

    public getAllProducts(): Observable<any>{
        return this.httpClient.get(this.getAllProductsApi);
    }

    getDetailsById(pid: any) : Observable<any>{
        return this.httpClient.get(this.getDetailsByIdApi + pid);
      }
  
      uploadImage(formData: FormData, id: any):Observable<any> {
          return this.httpClient.post('http://localhost:8081/api/product/image/upload/'+ id, formData)
      }
}