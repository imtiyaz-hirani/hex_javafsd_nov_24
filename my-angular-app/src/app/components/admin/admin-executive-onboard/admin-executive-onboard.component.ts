import { NgFor, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../../service/admin.service';
import { FormControl, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';

@Component({
  selector: 'app-admin-executive-onboard',
  imports: [NgIf, NgFor, ReactiveFormsModule],
  templateUrl: './admin-executive-onboard.component.html',
  styleUrl: './admin-executive-onboard.component.css'
})
export class AdminExecutiveOnboardComponent implements OnInit{

  successMsg: string | undefined;
  errorMsg: string | undefined; 
  departments: any[] =[];
  jobTitles: any[] = [];
  executiveForm : FormGroup; 
   

  constructor(private adminService: AdminService){ 
    this.executiveForm = new FormGroup({
      name: new FormControl('',[Validators.required]),
      contact: new FormControl('',[Validators.required, Validators.minLength(10), Validators.maxLength(10)]),
      department: new FormControl('',[Validators.required]),
      jobTitle: new FormControl('',[Validators.required]),
      username: new FormControl('',[Validators.required,Validators.minLength(4)]),
      password: new FormControl('',[Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/)]),
      rePassword: new FormControl('',[Validators.required,Validators.pattern(/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$/)])
    })

  }
   
  ngOnInit(): void {
     this.adminService.getAllDepartments().subscribe({
      next: (data)=>{
        this.departments = data; 
      },
      error: (err)=>{}
     });

     this.adminService.getAllJobTitles().subscribe({
      next: (data)=>{
        this.jobTitles = data; 
      },
      error: (err)=>{}
     });


  }

  onFormSubmit(){
    //console.log(this.executiveForm.value)
    if( this.executiveForm.value.password != this.executiveForm.value.rePassword){
       this.errorMsg='Passwords do not match, please try again..';
       this.successMsg = undefined; 
       return; 
    }
    this.adminService.postExecutive(this.executiveForm.value).subscribe({
      next: (data)=>{
        this.successMsg = 'Executive Onboarded. ';
        this.errorMsg = undefined; 
      },
      error: (err)=>{
        this.errorMsg = err.error.msg; 
      }
    })
  }
  
  resetMsg(){
    this.errorMsg = undefined; 
    this.successMsg = undefined; 
  }
}
