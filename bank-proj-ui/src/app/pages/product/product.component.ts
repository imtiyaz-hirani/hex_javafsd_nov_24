import { Component } from '@angular/core';
import { ProductNavbarComponent } from "../../components/product-navbar/product-navbar.component";
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-product',
  imports: [ProductNavbarComponent,RouterOutlet],
  templateUrl: './product.component.html',
  styleUrl: './product.component.css'
})
export class ProductComponent {

}
