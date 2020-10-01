import { UserAuthenticationService } from './../service/user-authentication.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username = "Gunjan"
  password = "mimo"
  errorMessage = "invalid credentials"
  invalideLogin = false
  //router

  constructor(private router: Router, private userAuthentication: UserAuthenticationService) { }

  ngOnInit(): void {
  }
  handleLogin() {
    if (this.userAuthentication.authenticate(this.username, this.password)) {
      //Redirecting to welcome page
      this.router.navigate(["welcome/" + this.username])
      this.invalideLogin = false
    }
    else {
      this.invalideLogin = true
    }

  }

}
