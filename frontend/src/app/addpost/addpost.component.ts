import { Component } from '@angular/core';
import {Post} from "../services/models/post";
import {PostControllerService} from "../services/services/post-controller.service";
import {HttpContext} from "@angular/common/http";
import {Attachment} from "../services/models/attachment";
import {FileUploadService} from "../services/file-upload/file-upload.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-addpost',
  templateUrl: './addpost.component.html',
  styleUrl: './addpost.component.css'
})
export class AddpostComponent {

      constructor(private postService : PostControllerService,
      private context: HttpContext,
      private fileUploader : FileUploadService,
                  private router: Router){
      }

      post: Post = {
        attachment: undefined,
        author: undefined,
        id: 0,
        lastEdit: "",
        publishedTime: "",
        text: "",
        title: ""
      }
      attachment?: File


        addAttachment(event: any){

         if(event.target.file) {
           const file: File = event.target.file[0]
           if (file && this.post) {
             this.post.attachment = this.fileUploader.uploadFile(file);
           }
         }

}

      upload(){
          if(this.post == null){throw new Error()}
          console.log("Post is being uploaded")
        this.postService.postPost({body : this.post}, this.context)
        this.router.navigate(['popular'])
      }
}
