import { Routes } from '@angular/router';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { ProfileComponent } from './components/profile/profile.component';
import { TransferComponent } from './components/transfer/transfer.component';
import { FdProcessComponent } from './components/fd-process/fd-process.component';
import { StatementComponent } from './components/statement/statement.component';
import { PageNotFoundComponent } from './components/page-not-found/page-not-found.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './pages/login/login.component';

export const routes: Routes = [
    {
        path: '', component: LoginComponent
    },
    {
        path: 'dashboard' , component: DashboardComponent, children:[
            {
                path:'', component: HomeComponent
            },
            {
                path: 'profile', component: ProfileComponent
            },
            {
                path: 'transfer', component: TransferComponent
            },
            {
                path: 'fd', component: FdProcessComponent
            },
            {
                path: 'statement', component: StatementComponent
            },
            {
                path: '**', component: PageNotFoundComponent
            },
        ]
    }
];
