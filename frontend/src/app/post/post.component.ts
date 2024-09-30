import {Component, Input} from '@angular/core';
import {faThumbsUp} from "@fortawesome/free-solid-svg-icons";
import {LikeControllerService} from "../services/services/like-controller.service";
import {CommentControllerService} from "../services/services/comment-controller.service";
import {Comment} from "../services/models/comment";
import {FileUploadService} from "../services/file-upload/file-upload.service";
import {PostDto} from "../services/models/post-dto";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrl: './post.component.css'
})
export class PostComponent {
   @Input()
    post: PostDto = {} as PostDto
    showComments: boolean = false
    comment: Comment = {} as Comment
    attachment: File = {} as File

  constructor(private likeController: LikeControllerService,
              private commentController: CommentControllerService,
              private fileUploader: FileUploadService) {

  }

  likePost(){
     if(this.post) {
       if(!this.post.liked) {
         this.likeController.addLike({likedId: this.post.post?.id || 0})
       }else{
         this.likeController.unlike({likedId: this.post.post?.id || 0})
       }
     }
  }

  sendComment(){
     this.assignAttachment();
     this.commentController.addComment({commented_id: this.post.post?.id || 0, body: this.comment})
  }

  private assignAttachment(){
     this.comment.attachment = this.fileUploader.uploadFile(this.attachment)
  }
  protected readonly faThumbsUp = faThumbsUp;
}
