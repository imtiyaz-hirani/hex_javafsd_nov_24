import { Component, OnInit } from '@angular/core';
import { ProductService } from '../../services/product.service';
import { NgFor } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-product-list',
  imports: [NgFor, RouterLink],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.css'
})
export class ProductListComponent implements OnInit{

  products: any[]= []
  constructor(private productService: ProductService){
    this.productService.getAllProducts().subscribe({
      next:(data)=>{
        this.products = data; 
        this.products.forEach(p=>{
          p.images.forEach((i:any) => {
            i.path = './images/'+ i.fileName
          });
        })
        console.log(this.products)
       
      },
      error:()=>{}
    })
  }
  
  ngOnInit(): void {
    
  }


}
