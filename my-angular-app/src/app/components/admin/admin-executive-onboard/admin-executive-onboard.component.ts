import { NgFor, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../../service/admin.service';

@Component({
  selector: 'app-admin-executive-onboard',
  imports: [NgIf, NgFor],
  templateUrl: './admin-executive-onboard.component.html',
  styleUrl: './admin-executive-onboard.component.css'
})
export class AdminExecutiveOnboardComponent implements OnInit{

  successMsg: string | undefined;
  errorMsg: string | undefined; 
  departments: any[] =[];
  jobTitles: any[] = [];
  
  constructor(private adminService: AdminService){ }
  
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

  
}
