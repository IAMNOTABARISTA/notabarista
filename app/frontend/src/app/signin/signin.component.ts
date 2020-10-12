import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserAuthenticationService } from '../services/user-authentication.service';

@Component({
  selector: 'app-signin',
  templateUrl: './signin.component.html',
  styleUrls: ['./signin.component.css']
})
export class SigninComponent implements OnInit {

  name: String = ""
  username: String = ""
  email: String = ""
  password: String = ""

  errorMessage = ""

  constructor(private router: Router, private userAuthenticationService: UserAuthenticationService) { }

  ngOnInit(): void {
  }
  handleSign() {
    // to pass the username with welcome link like welcome/username
    if (this.userAuthenticationService.userSignIn(this.username, this.password)) {
      this.router.navigate(["welcome/" + this.username])
    } else {
      this.errorMessage = "try once more!"
    }
  }

}
