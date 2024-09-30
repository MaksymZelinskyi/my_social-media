import {Component, Input} from '@angular/core';
import {User} from "../services/models/user";
import {UserControllerService} from "../services/services/user-controller.service";
import {UserInListDto} from "../services/models/user-in-list-dto";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrl: './users.component.css'
})
export class UsersComponent {

  @Input()
  users: Array<UserInListDto> = new Array<UserInListDto>

}
