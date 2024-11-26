import { Component, OnInit } from '@angular/core';
import { ChartModule } from 'primeng/chart';
import { AdminService } from '../../../service/admin.service';

@Component({
  selector: 'app-admin-dashboard',
  imports: [ChartModule],
  templateUrl: './admin-dashboard.component.html',
  styleUrl: './admin-dashboard.component.css'
})
export class AdminDashboardComponent implements OnInit{
  
  basicData: any;
  basicOptions: any;
  labels: string[] = [];
  stataData: number[] =[];

  constructor(private adminService: AdminService){

  }
  ngOnInit(): void {
        const documentStyle = getComputedStyle(document.documentElement);
        const textColor = documentStyle.getPropertyValue('--text-color');
        const textColorSecondary = documentStyle.getPropertyValue('--text-color-secondary');
        const surfaceBorder = documentStyle.getPropertyValue('--surface-border');

    this.adminService.getUserStat().subscribe({
      next:(resp)=>{
        console.log(resp)
        this.labels = resp.labels; 
        this.stataData = resp.data; 
        this.basicData = {
          labels:  this.labels,
          datasets: [
              {
                  label: 'Number of Users',
                  data: this.stataData,
                  backgroundColor: ['rgba(255, 159, 64, 0.2)', 'rgba(75, 192, 192, 0.2)', 'rgba(54, 162, 235, 0.2)', 'rgba(153, 102, 255, 0.2)'],
                  borderColor: ['rgb(255, 159, 64)', 'rgb(75, 192, 192)', 'rgb(54, 162, 235)', 'rgb(153, 102, 255)'],
                  borderWidth: 1
              }
          ]
        };
        this.basicOptions = {
        plugins: {
            legend: {
                labels: {
                    color: textColor
                }
            }
        },
        scales: {
            y: {
                beginAtZero: true,
                ticks: {
                    color: textColorSecondary
                },
                grid: {
                    color: surfaceBorder,
                    drawBorder: false
                }
            },
            x: {
                ticks: {
                    color: textColorSecondary
                },
                grid: {
                    color: surfaceBorder,
                    drawBorder: false
                }
            }
        }
        };
      },
      error: ()=>{}
    })    
    


  
  }
}
