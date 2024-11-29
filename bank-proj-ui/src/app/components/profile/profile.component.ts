import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { CustomerService } from '../../services/customer.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-profile',
  imports: [ReactiveFormsModule,NgIf],
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent implements OnInit{
  profileForm: FormGroup;
  customer: any; 
  msg: any| undefined; 
  customerCopy: any;
  constructor(private customerService: CustomerService){ 
    this.profileForm = new FormGroup({
      name: new FormControl('' ,[Validators.required]),
      contact: new FormControl('',[Validators.required]),
      addressLine1: new FormControl('',[Validators.required]),
      addressLine2: new FormControl('',[Validators.required]),
      city: new FormControl('',[Validators.required]),
      state: new FormControl('',[Validators.required]),
      zip: new FormControl('',[Validators.required]),
    });
  }

  ngOnInit(): void {
    this.customerService.getCustomerDetailsByUsername(localStorage.getItem('username'))
    .subscribe({
      next:(data)=>{
        this.customer = data; 
        this.customerCopy = data; 
        this.profileForm = new FormGroup({
          name: new FormControl(this.customer.name ,[Validators.required]),
          contact: new FormControl(this.customer.contact,[Validators.required]),
          addressLine1: new FormControl(this.customer.address.addressLine1,[Validators.required]),
          addressLine2: new FormControl(this.customer.address.addressLine2,[Validators.required]),
          city: new FormControl(this.customer.address.city,[Validators.required]),
          state: new FormControl(this.customer.address.state,[Validators.required]),
          zip: new FormControl(this.customer.address.zip,[Validators.required]),
        });
      },
      error: (err)=>{}
    })
     
  }

  saveProfile(){
    console.log(this.customer);
    this.customer.name=this.profileForm.value.name; 
    this.customer.contact = this.profileForm.value.contact; 
    this.customer.address.addressLine1 = this.profileForm.value.addressLine1;
    this.customer.address.addressLine2 = this.profileForm.value.addressLine2;
    this.customer.address.city = this.profileForm.value.city;
    this.customer.address.state = this.profileForm.value.state;
    this.customer.address.zip = this.profileForm.value.zip;
    console.log(this.customer);
    console.log(this.customerCopy);
    //logic for checking if there is any update to be done.. 
    
    this.customerService.updateProfile(this.customer).subscribe({
      next:(data)=>{
        this.customer = data; 
        this.msg = 'Profile Updated..'
      },
      error:()=>{}
    })
  }
}
