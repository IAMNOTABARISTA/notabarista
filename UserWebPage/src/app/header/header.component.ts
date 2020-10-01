import { UserAuthenticationService } from './../service/user-authentication.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  //isUserLoggedIn: boolean
  constructor(public disableMenu: UserAuthenticationService) { }

  ngOnInit(): void {
    //this.isUserLoggedIn = this.disableMenu.isUserLoggedIn()
  }


}
