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
  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  handleLogin() {
    this.router.navigate(["welcome/" + this.username])
  }

}
