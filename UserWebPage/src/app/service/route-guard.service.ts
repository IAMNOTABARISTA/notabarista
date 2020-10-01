import { UserAuthenticationService } from './user-authentication.service';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class RouteGuardService implements CanActivate {

  constructor(private userLoginStatus: UserAuthenticationService, private router: Router) { }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
    if (this.userLoginStatus.isUserLoggedIn()) {

      return true;
    }
    this.router.navigate(['login'])
    return false
  }
}
