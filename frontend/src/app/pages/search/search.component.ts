import { Component } from '@angular/core';
import {UserInListDto} from "../../services/models/user-in-list-dto";
import {SearchControllerService} from "../../services/services/search-controller.service";
import {User} from "../../services/models/user";
import {Post} from "../../services/models/post";
import {FormControl, FormGroup} from "@angular/forms";
import {PostDto} from "../../services/models/post-dto";

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrl: './search.component.css'
})
export class SearchComponent {

  query= ""
  foundUsers = new Array<UserInListDto>()
  foundPosts = new Array<PostDto>()
  queryForm = new FormGroup({
    query: new FormControl()
  })

  constructor(private searcher: SearchControllerService){
  }

  searchUser(){
    this.foundPosts = new Array<PostDto>()
    this.searcher.searchUsers({body: this.query}).subscribe(
      (next)=>{
        this.foundUsers = next
      }
    )
  }

  searchPost(){
    this.foundUsers = new Array<UserInListDto>()
    this.searcher.searchPosts({body: this.query}).subscribe(

      (next)=>{
        this.foundPosts = next
      }
    )
  }
}
