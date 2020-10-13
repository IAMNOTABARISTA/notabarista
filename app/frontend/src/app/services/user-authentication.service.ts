import { User } from './../classes/user';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class UserAuthenticationService {

  constructor(private http: HttpClient) { }

  public authentication(user: User): Observable<any> {
    return this.http.post<any>("http://localhost:8080/login", user)
  }


  // authentication(username, password) {
  //   if (username === "gunjan" && password === "gunjanpaul") {
  //     sessionStorage.setItem("authenticateUser", username)
  //     return true
  //   }
  //   return false
  // }

  // to chech user is logged in or not
  isUserLoggedIn() {
    var user = sessionStorage.getItem("authenticateUser")
    return !(user === null)
  }

  //sign service
  userSignIn(username, password) {
    if (password.length >= 6 && !username.includes("@")) {
      sessionStorage.setItem("authenticateUser", username)
      return true
    }
    return false
  }


  //log out service
  logout() {
    // removign sessio storage
    sessionStorage.removeItem("authenticateUser")
  }
}
