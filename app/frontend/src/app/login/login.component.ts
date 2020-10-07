import { UserAuthenticationService } from './../services/user-authentication.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  username = "gunjan"
  password = "gunjanpaul"
  errorMessage = "Invalid credentials"
  invalidLogin = false
  constructor(private router: Router, private userAuthenticationService: UserAuthenticationService) { }

  ngOnInit(): void {
  }

  // this function is listenting to the event of login button of login page
  handleLogin() {
    //console.log("username " + this.username + " password: " + this.password)
    if (this.userAuthenticationService.authentication(this.username, this.password)) {
      this.router.navigate(["welcome/" + this.username])
      this.invalidLogin = false
    } else {
      this.invalidLogin = true
    }
  }

}
