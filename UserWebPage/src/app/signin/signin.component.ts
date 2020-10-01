import { UserAuthenticationService } from './../service/user-authentication.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {
  name = ""
  username = ""
  email = ""
  password = ""
  validPassword: boolean
  constructor(private router: Router, private signInAuthentication: UserAuthenticationService) { }

  ngOnInit(): void {
  }
  handleSingUp() {
    if (this.signInAuthentication.authenticateSignIn(this.name, this.username, this.password, this.email)) {
      this.router.navigate(["welcome/" + this.username])
      this.validPassword = false
    }
    this.validPassword = true
  }
}
