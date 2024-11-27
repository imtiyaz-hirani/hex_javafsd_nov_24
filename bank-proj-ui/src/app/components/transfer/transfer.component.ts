import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { CustomerService } from '../../services/customer.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-transfer',
  imports: [NgFor, FormsModule, NgIf],
  templateUrl: './transfer.component.html',
  styleUrl: './transfer.component.css'
})
export class TransferComponent {
  myAccounts: any[] =[];
  accountNum: any; 
  customer: any | undefined; 

  constructor(private customerService: CustomerService){
    this.customerService.getAllAccounts(localStorage.getItem('username'))
    .subscribe({
      next:(data)=>{
        this.myAccounts = data; 
      },
      error: ()=>{}
    }) 
    
    // this.myAccounts = [{
    //   accountNumber: 'AC4569065867489',
    //   accountType: 'SAVINGS',
    //   balance: 59000,
    //   limit: 200000
    // },
    // {
    //   accountNumber: 'AC445HGJ677899J',
    //   accountType: 'CURRENT',
    //   balance: 568000,
    //   limit: 500000
    // }
    // ]
  }

  verify(){
    //console.log(this.accountNum)
    this.customerService.getCustomerDetailsByAccountNo(this.accountNum)
    .subscribe({
      next:(data)=>{
        this.customer = data; 
      },
      error: ()=>{}
    })
  }
}
