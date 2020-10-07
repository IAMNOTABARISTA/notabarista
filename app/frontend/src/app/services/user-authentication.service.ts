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

}
