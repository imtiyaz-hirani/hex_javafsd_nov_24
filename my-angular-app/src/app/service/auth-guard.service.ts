import { Injectable } from "@angular/core";
import { ActivatedRouteSnapshot, CanActivate, GuardResult, MaybeAsync, Router, RouterStateSnapshot } from "@angular/router";
import { Observable,of } from "rxjs";

@Injectable({
    providedIn:'root'
})
export class AuthGuardService implements CanActivate {

    token: string | undefined | null; 
    username : string | undefined | null; 
    accessData=[{
        path: 'admin',
        role:'ADMIN'
    },
    {
       path: 'customer',
        role:'CUSTOMER' 
    }]
    constructor(private router:Router){
        this.token = localStorage.getItem('token');
        this.username = localStorage.getItem('username');
    }
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): MaybeAsync<GuardResult> {
        
        console.log('I am blocking everything');
        console.log('token: ' + this.token)
        console.log('username: ' + this.username)
        console.log(route)
        console.log(state)
        //if someone is not logged in, the values of token and username are null. 
        //else, they are loggedIn. 
        if(this.token === null || this.username === null){ 
            this.router.navigateByUrl('**'); 
            return false; 
    }
        let pathVal = route.routeConfig?.path;
        let role = localStorage.getItem('role'); 

        let allowedObj = this.accessData.filter(e=>e.path === pathVal)[0];
         console.log(allowedObj)
         if(allowedObj.role === role){
            return true; 
         }
         console.log('invalid role ');
         this.router.navigateByUrl('**'); 
        return false; 
    }
     

}

/**
 * Router gives u an interface, CanActivate 
 * 
 */