import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthenticationService {

  constructor() { }


  //login authenticatiom
  authenticate(username, password) {

    if (username === "Gunjan" && password === "mimo") {
      sessionStorage.setItem("authenticatedUser", username)
      return true;
    }
    return false;
  }

  // authenticate user signin
  authenticateSignIn(name, username, password: string, email: string) {
    if (password.length >= 6) {
      sessionStorage.setItem("authenticatedUser", username)
      sessionStorage.setItem("name", name)
      sessionStorage.setItem("email", email)
      return true
    }
    return false
  }



  isUserLoggedIn() {
    let user = sessionStorage.getItem("authenticatedUser")
    return !(user == null)
  }
  loggedOut() {
    sessionStorage.removeItem("authenticatedUser")
    sessionStorage.removeItem("name")
    sessionStorage.removeItem("email")
  }
}
