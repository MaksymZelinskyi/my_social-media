import {Component, Input} from '@angular/core';
import {Comment} from "../../services/models/comment";
import {CommentControllerService} from "../../services/services/comment-controller.service";
import {getPostComments} from "../../services/fn/comment-controller/get-post-comments";
import {faThumbsUp} from "@fortawesome/free-solid-svg-icons";

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrl: './comment.component.css'
})
export class CommentComponent {

  constructor(private service: CommentControllerService) {
  }

  @Input()
  commentedId = 0;
  comments: Array<Comment> = [];
  showComments = false
  comment = {} as Comment

  getComments(id: number = this.commentedId): Array<Comment> {
    this.service.getPostComments(
      {
        lastCommentTime: this.comments[this.comments.length].publishedTime, postId: this.commentedId
      }
    ).subscribe(
      (next) => {
        this.comments = next
      }
    );
    return this.comments;
  }

  sendComment(){
    this.service.addComment({commented_id: this.commentedId, body: this.comment})
  }


  protected readonly getPostComments = getPostComments;
  protected readonly faThumbsUp = faThumbsUp;
}
