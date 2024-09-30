import {Component, Input} from '@angular/core';
import {UserInListDto} from "../services/models/user-in-list-dto";
import {Router} from "@angular/router";

@Component({
  selector: 'app-user-in-list',
  templateUrl: './user-in-list.component.html',
  styleUrl: './user-in-list.component.css'
})
export class UserInListComponent {

  @Input()
  user: UserInListDto = {} as UserInListDto

  constructor(private router: Router) {
  }
  goToUserPage(){
    this.router.navigate(['users/' + this.user?.id])
  }
}
