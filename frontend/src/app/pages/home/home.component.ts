import { Component } from '@angular/core';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import {Router} from "@angular/router";
import {UserControllerService} from "../../services/services/user-controller.service";
import {faEarthEurope, faEye, faIdCard, faPlus} from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  subPages = ['add-post', 'view-profile', 'feed', 'search']
  currentPage = this.subPages[0]

  constructor(private sessionStorage: Storage) {

  }

  protected readonly faEye = faEye;
  protected readonly faPlus = faPlus;
  protected readonly faIdCard = faIdCard;
  protected readonly faEarthEurope = faEarthEurope;

  protected readonly localStorage = localStorage;
  protected readonly Number = Number;
}
