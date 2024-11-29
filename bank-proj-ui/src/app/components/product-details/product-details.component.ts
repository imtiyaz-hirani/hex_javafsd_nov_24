import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../../services/product.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-product-details',
  imports: [NgFor],
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.css'
})
export class ProductDetailsComponent {
  
  pid: any; 
  product: any; 
  file: any; 

  constructor(private actRoute:ActivatedRoute, private productService: ProductService){
    this.getProductDetails();
    
  }

  getProductDetails(){
    this.actRoute.paramMap.subscribe(p=>{
      this.pid = p.get('id'); 
      this.productService.getDetailsById(this.pid).subscribe({
        next:(data)=>{
          this.product = data; 
          this.product.images.forEach((i:any) => {
            i.path = './images/'+ i.fileName
          });
        },
        error: ()=>{}
      })
    })
  }
  onFileSelect(evnt: any){
    console.log(evnt.target.files[0])
    this.file = evnt.target.files[0]
  }

  uploadFile(){
    let formData = new FormData();
    formData.set('file', this.file);
    this.productService.uploadImage(formData, this.product.id).subscribe({
      next:(data)=>{
        this.productService.getDetailsById(this.pid).subscribe({
          next:(data)=>{
            this.product = data; 
            this.product.images.forEach((i:any) => {
              i.path = './images/'+ i.fileName
            });
          },
          error: ()=>{}
        })
        
      },
      error:()=>{}
    })
  }
}
