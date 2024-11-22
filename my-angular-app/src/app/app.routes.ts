import { Routes } from '@angular/router';
import { DashboardPageComponent } from './pages/dashboard-page/dashboard-page.component';
import { UserPageComponent } from './pages/user-page/user-page.component';
import { TodoPageComponent } from './pages/todo-page/todo-page.component';
import { PostPageComponent } from './pages/post-page/post-page.component';
import { PageNotFoundComponent } from './pages/page-not-found/page-not-found.component';
import { SignupComponent } from './pages/signup/signup.component';

export const routes: Routes = [
    {
        path: '' , component: DashboardPageComponent
    },
    {
        path:'user', component : UserPageComponent
    },
    {
        path: 'todo', component : TodoPageComponent
    },
    {
        path: 'posts', component : PostPageComponent
    },
    {
        path:'sign-up', component : SignupComponent
    },
    {
        path: '**', component : PageNotFoundComponent
    }
];
