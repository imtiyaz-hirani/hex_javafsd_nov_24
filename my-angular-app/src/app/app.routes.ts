import { Routes } from '@angular/router';
import { DashboardPageComponent } from './pages/dashboard-page/dashboard-page.component';
import { UserPageComponent } from './pages/user-page/user-page.component';
import { TodoPageComponent } from './pages/todo-page/todo-page.component';
import { PostPageComponent } from './pages/post-page/post-page.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import { AuthPageComponent } from './pages/auth-page/auth-page.component';
import { AdminPageComponent } from './pages/admin-page/admin-page.component';
import { CustomerPageComponent } from './pages/customer-page/customer-page.component';
import { AdminExecutiveOnboardComponent } from './components/admin/admin-executive-onboard/admin-executive-onboard.component';
import { AdminExecutiveListComponent } from './components/admin/admin-executive-list/admin-executive-list.component';

export const routes: Routes = [
    {
        path: '' , component: AuthPageComponent, children: [
            {
                path:'login', component : LoginComponent
            },
            {
                path:'sign-up', component : SignupComponent
            }
        ]
        }   
        ,
    {
        path:'admin', component : AdminPageComponent, children:[
            {
                path:'onboard-executive', component : AdminExecutiveOnboardComponent
            },
            {
                path:'manage-executive', component : AdminExecutiveListComponent
            }
        ]
    },
    {
        path:'customer', component : CustomerPageComponent
    },
    {
        path:'user', component : UserPageComponent
    },
    {
        path: 'todo', component : TodoPageComponent
    },
    {
        path: 'posts', component : PostPageComponent
    } 
    
    ,
    {
        path: '**', component : PageNotFoundComponent
    }
];
