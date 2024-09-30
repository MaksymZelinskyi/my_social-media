import {Component, HostListener} from '@angular/core';
import {Post} from "../../services/models/post";
import {HomeControllerService} from "../../services/services/home-controller.service";
import {CommentControllerService} from "../../services/services";
import {getPostComments} from "../../services/fn/comment-controller/get-post-comments";
import {PostDto} from "../../services/models/post-dto";

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrl: './feed.component.css'
})
export class FeedComponent {

  constructor(
    private homeControllerService: HomeControllerService,
  ) {
  }

  following: boolean = false
  posts : Array<PostDto> = new Array<PostDto>()
  isLoading : boolean = false

  onSelectFollowing(){
    if(!this.following){
      this.following=true
      this.posts = new Array<PostDto>()
      this.getFollowingPosts()
    }
  }

  onSelectPopular(){
    if(this.following){
      this.following=false
      this.posts = new Array<PostDto>()
      this.getMostPopularPosts()
    }
  }

  getMostPopularPosts(): void {
    this.isLoading = true
    this.homeControllerService.getPopularPosts().subscribe(
      value=> {
        this.posts = this.posts.concat(value)
      },
      error => {
        console.error(error)
      },
    );
    this.isLoading = false
  }

  getFollowingPosts(){
    this.isLoading = true
    this.homeControllerService.getPostsOfFollowing().subscribe(
      value=> {
        this.posts = this.posts.concat(value)
      },
      error => {
        console.error(error)
      },
    );
    this.isLoading = false
  }

  @HostListener("window:scroll", ['$event'])
  onScroll(){
    if(this.isLoading){return}

    const windowHeight = window.innerHeight
    const documentHeight = document.body.offsetHeight
    const scrollPosition = window.scrollY
    if(scrollPosition>=documentHeight-windowHeight){
      this.getMostPopularPosts()
    }
  }

  protected readonly CommentControllerService = CommentControllerService;
  protected readonly getPostComments = getPostComments;

}
