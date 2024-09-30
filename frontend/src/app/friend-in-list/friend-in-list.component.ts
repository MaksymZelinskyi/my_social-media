import {Component, inject, Input} from '@angular/core';
import {Router} from "@angular/router";
import {UserInListDto} from "../services/models/user-in-list-dto";
import {FriendInListDto} from "../services/models/friend-in-list-dto";

@Component({
  selector: 'app-friend',
  templateUrl: './friend-in-list.component.html',
  styleUrl: './friend-in-list.component.css'
})
export class FriendInListComponent {

  @Input()
  user: FriendInListDto = {}
  router = inject(Router)

  goToUserPage(){
    this.router.navigate(['users/' + this.user.id])
  }
}
