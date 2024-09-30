import {Component, HostListener, Input} from '@angular/core';
import {UserControllerService} from "../../services/services/user-controller.service";
import {ActivatedRoute, Router} from "@angular/router";
import {SubscriptionControllerService} from "../../services/services/subscription-controller.service";
import {Post} from "../../services/models/post";
import {PostControllerService} from "../../services/services/post-controller.service";
import {ProfileDto} from "../../services/models/profile-dto";
import {PostDto} from "../../services/models/post-dto";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {

  user: ProfileDto = {}
  @Input()
  userId: number = 0
  posts: Array<PostDto> = new Array<PostDto>()
  isLoading: boolean = false

  constructor(private service: UserControllerService,
    private subscriptionService: SubscriptionControllerService,
    private postService: PostControllerService,
    private router: Router,
              private route: ActivatedRoute) {
    route.params.subscribe((params) => {
      this.userId = params["id"]
    })
    service.getUser({id: this.userId}).subscribe(
      (next) => {
        this.user = next
      }
    )
  }

  subscribe(){
    this.subscriptionService.subscribe({userId: this.userId})
  }

  @HostListener("window:scroll", ['$event'])
  onScroll(){
    if(this.isLoading){return}

    const windowHeight = window.innerHeight
    const documentHeight = document.body.offsetHeight
    const scrollPosition = window.scrollY
    if(scrollPosition>=documentHeight-windowHeight){
      this.getLastPosts()
    }
  }

  getLastPosts(){
    this.isLoading = true

    this.service.getPosts({id: this.userId, lastSeenPTime: this.posts[-1].post?.publishedTime || '' }).subscribe(
      (next)=>{
        this.posts.concat(next)
      }
    )
    this.isLoading = false
  }
}
