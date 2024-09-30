import {Component, Input} from '@angular/core';
import {SubscriptionControllerService} from "../services/services/subscription-controller.service";
import {FriendInListDto} from "../services/models/friend-in-list-dto";

@Component({
  selector: 'app-friends',
  templateUrl: './friends.component.html',
  styleUrl: './friends.component.css'
})
export class FriendsComponent {

    userId = 0
    friends: Array<FriendInListDto> = new Array<FriendInListDto>()

  constructor(private controller: SubscriptionControllerService,
              private location: Location) {
  }

    fetchUsers(){
      if(this.location.pathname.endsWith("subscriptions")) {
        this.controller.getSubscriptions({userId: this.userId, previousSubscriptionTime: this.friends[-1].subscriptionTime, count: 35}).subscribe(
          (next)=>{this.friends.concat(next)}
        )
      }
      if(this.location.pathname.endsWith("followers")) {
        this.controller.getFollowers({userId: this.userId, previousSubscriptionTime: this.friends[-1].subscriptionTime, count: 35}).subscribe(
          (next)=>{this.friends.concat(next)}
        )
      }
    }
}
