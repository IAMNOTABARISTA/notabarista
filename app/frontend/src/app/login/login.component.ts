import { Component, OnInit } from '@angular/core';

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
  constructor() { }

  ngOnInit(): void {
  }

  // this function is listenting to the event of login button of login page
  handleLogin() {
    //console.log("username " + this.username + " password: " + this.password)
    if (this.username === "gunjan" && this.password === "gunjanpaul") {
      this.invalidLogin = false
    } else {
      this.invalidLogin = true
    }
  }

}
