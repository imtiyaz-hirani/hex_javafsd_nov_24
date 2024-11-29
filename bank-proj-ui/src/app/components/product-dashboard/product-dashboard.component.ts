import { Component } from '@angular/core';
import { ProductListComponent } from "../product-list/product-list.component";

@Component({
  selector: 'app-product-dashboard',
  imports: [ProductListComponent],
  templateUrl: './product-dashboard.component.html',
  styleUrl: './product-dashboard.component.css'
})
export class ProductDashboardComponent {

}
