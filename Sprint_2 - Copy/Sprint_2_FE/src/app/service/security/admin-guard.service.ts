import {Injectable} from '@angular/core';
import {CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree} from '@angular/router';
import {TokenService} from './token.service';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdminGuardService implements CanActivate {
  constructor(private tokenService: TokenService,
              private router: Router) {
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    if (this.tokenService.getToken()) {
      if (JSON.stringify(this.tokenService.getRole()) == JSON.stringify(['ADMIN'])) {
        return true;
      } else {
        alert("Không có quyền của Admin");
        this.router.navigate(['home'])
      }
    } else {
      this.router.navigate(['home/login'])
    }
  }
}
