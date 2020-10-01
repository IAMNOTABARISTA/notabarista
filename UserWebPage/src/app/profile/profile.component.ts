import { Component, OnInit } from '@angular/core';
export class UserProfile {

  constructor(public name: String,
    public email: String,
    public location: String,
    public University: String) { }
}

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  name = sessionStorage.getItem("name")
  email = sessionStorage.getItem("email")
  profile = new UserProfile(this.name, this.email, "India", "UEM")

  constructor() { }

  ngOnInit(): void {
  }

}
