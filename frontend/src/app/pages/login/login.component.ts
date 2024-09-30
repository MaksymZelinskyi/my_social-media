import { Component } from '@angular/core';
import {AuthenticationRequest} from "../../services/models/authentication-request";
import {Router} from "@angular/router";
import {HomeControllerService} from "../../services/services/home-controller.service";
import {Login$Params} from "../../services/fn/home-controller/login";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  constructor(
    private router: Router,
    private homeService: HomeControllerService,
    private sessionStorage: Storage) {
  }
  userAuth : AuthenticationRequest = {username: "", password: ""}
  loginParams : Login$Params = {authenticationRequest: this.userAuth}

  login(){
    this.homeService.login(this.loginParams).subscribe(
      next => localStorage.setItem("currentId", next.toString())
    )
    this.router.navigate(["home"])
  }

  register(){
    this.router.navigate(['sign-up'])
  }
}
