import { Component } from '@angular/core';
import { AdminNavbarComponent } from "../../components/admin/admin-navbar/admin-navbar.component";
import { AdminSidebarComponent } from "../../components/admin/admin-sidebar/admin-sidebar.component";
import { AdminExecutiveListComponent } from "../../components/admin/admin-executive-list/admin-executive-list.component";
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-admin-page',
  imports: [AdminNavbarComponent, AdminSidebarComponent, RouterOutlet],
  templateUrl: './admin-page.component.html',
  styleUrl: './admin-page.component.css'
})
export class AdminPageComponent {

}
