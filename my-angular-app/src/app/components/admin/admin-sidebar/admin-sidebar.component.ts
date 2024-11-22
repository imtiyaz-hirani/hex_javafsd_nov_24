import { NgClass } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-admin-sidebar',
  imports: [RouterLink, NgClass],
  templateUrl: './admin-sidebar.component.html',
  styleUrl: './admin-sidebar.component.css'
})
export class AdminSidebarComponent {
  linkType: string='manage';
   
  linkClick(linkType:string){
    this.linkType = linkType;
  }

  getClassOn(){
    return {
      active: this.linkType === 'onboard'?true: false
    }
  }

  getClassMa(){
    return {
      active: this.linkType === 'manage'?true: false
    }
  }
}
