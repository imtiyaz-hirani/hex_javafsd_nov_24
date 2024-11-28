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
  beneficiaryAccountNum: any | undefined; 
  customer: any | undefined; 
  senderAccountNum: any | undefined; 
  msg:string | undefined; 
  isEnabled: boolean = false; 
  amount: any;

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
    console.log(this.beneficiaryAccountNum)
    console.log(this.senderAccountNum)
    this.validate()
    if(this.beneficiaryAccountNum == this.senderAccountNum){
      this.msg = "Cannot transfer to same account";
      this.customer = undefined
    }
    else{
      this.customerService.getCustomerDetailsByAccountNo(this.beneficiaryAccountNum)
    .subscribe({
      next:(data)=>{
        this.customer = data; 
        this.msg = undefined
      },
      error: ()=>{}
    })
    }
     
    
      
  }


  transfer(){
      console.log('in transfer...')
  }

  validate(){
    console.log('validate called...')
    console.log(this.senderAccountNum)
    console.log(this.beneficiaryAccountNum)
    console.log(this.amount)

      if(this.senderAccountNum != undefined 
              && this.beneficiaryAccountNum != undefined 
                  && this.amount != undefined){
                    console.log('check 1 done... ')
                        if(this.senderAccountNum !== this.beneficiaryAccountNum) {
                              console.log('check 2 done... ')
                                let acct = this.myAccounts.find(a=>a.accountNum == this.senderAccountNum)
                                console.log("account info: " + acct)
                                if(acct != undefined && acct.balance > this.amount){
                                    console.log('check 3 done... ')
                                    this.isEnabled = true; 
                                }
                        } 
                        else{
                          this.isEnabled = false;
                        }        
      }
      else{
        this.isEnabled = false;
      }
     
  }
}
