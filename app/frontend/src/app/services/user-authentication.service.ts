import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserAuthenticationService {

  constructor() { }
  authentication(username, password) {
    if (username === "gunjan" && password === "gunjanpaul") {
      sessionStorage.setItem("authenticateUser", username)
      return true
    }
    return false
  }
  isUserLoggedIn() {
    var user = sessionStorage.getItem("authenticateUser")
    return !(user === null)
  }

  //sign service
  userSignIn(username, password) {
    if (password.length >= 6) {
      sessionStorage.setItem("authenticateUser", username)

      return true
    }
    return false
  }


  logout() {
    sessionStorage.removeItem("authenticateUser")
  }
}
