import { Component } from '@angular/core';
import {User} from "../../services/models/user";
import {Router} from "@angular/router";
import {FileUploadService} from "../../services/file-upload/file-upload.service";
import {HomeControllerService} from "../../services/services/home-controller.service";
import {Register1$Params} from "../../services/fn/home-controller/register-1";

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
    hello ="Hello"
    user: User = {};
    profilePicture: File = new File([""], "default.png", {
    type: "image/png",
    lastModified: new Date().getTime()
    });

  registerParams: Register1$Params = {body: this.user};

  constructor(
    private router: Router,
    private fileUploader: FileUploadService,
    private service: HomeControllerService
  ) {

  }

  uploadProfilePicture(){
      this.user.profilePicture = this.fileUploader.uploadFile(this.profilePicture)
  }

    signUp(){
    this.hello = "sign up"
      this.uploadProfilePicture();
      this.registerParams.body=this.user
      this.hello = this.user.username || "Hello"
      this.service.register1(this.registerParams).subscribe(
        next => localStorage.setItem("currentId", next.toString())
      )
    }

  protected readonly onsubmit = onsubmit;
}
