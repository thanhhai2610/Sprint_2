import {Component, OnInit} from '@angular/core';
import {TokenService} from "../../service/security/token.service";
import {Router} from "@angular/router";
import {User} from "../../model/users/user";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  checkLogin: boolean;
  nameAccount: string;
  currentUser: User;
  accountRole: string;

  constructor(private _tokenService: TokenService,
              private _router: Router) {
  }

  ngOnInit(): void {
    if (this._tokenService.isLogged()) {
      this.checkLogin = true;

      this.currentUser = JSON.parse(this._tokenService.getUser());

      this.nameAccount = this.currentUser.lastname + ' ' + this.currentUser.firstname;

      // this.nameAccount = 'Thanh Hai';

      const roles = this._tokenService.getRole();

      for (let i = 0; i < roles.length; i++) {
        if (roles[i] === 'ROLE_ADMIN') {
          this.accountRole = 'ROLE_ADMIN';
        }
      }
    }
  }

  logOut() {
    this._tokenService.logOut();
    this._router.navigateByUrl('').then(() => {
      location.reload();
    });
  }

}
