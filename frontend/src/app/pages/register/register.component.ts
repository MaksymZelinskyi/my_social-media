import { HomeControllerService } from '../../services/services/home-controller.service';
import { FileUploadControllerService } from '../../services/services/file-upload-controller.service';
import { Register1$Params } from '../../services/fn/home-controller/register-1';
import { User } from '../../services/models/user'
import { Birthday } from '../../services/models/birthday'
import { HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { Component } from '@angular/core';

@Component({
  selector: 'register',
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  hello = "Hello";
  user: User = {
    email: "",
    followers: [],
    id: 0,
    likes: [],
    password: "",
    personalInfo: {
      firstName: '',
      lastName: '',
      birthDate: undefined,
      gender: 'CONCEALED'
    },
    posts: [],
    profilePicture: undefined,
    registrationDate: "",
    roles: [],
    subscriptions: [],
    username: ""
  };

  profilePicture: File = new File([""], "default.png", {
    type: "image/png",
    lastModified: new Date().getTime()
  });

  registerParams: Register1$Params = { body: this.user };

  constructor(
    private router: Router,
    private fileUploader: FileUploadControllerService,
    private service: HomeControllerService
  ) {}

  uploadProfilePicture(): void {
    this.fileUploader.uploadFile({ body: {file: this.profilePicture} }).subscribe({
      next: (uploadedAttachment) => {
        this.user.profilePicture = uploadedAttachment;
        this.finishSignUp(); // optionally continue registration after upload
      },
      error: (err) => {
        console.error("Failed to upload profile picture", err);
      }
    });
  }


  signUp(): void {
    this.hello = "sign up";
    this.uploadProfilePicture(); // will call finishSignUp() after upload
  }

  finishSignUp(): void {
    this.registerParams.body = this.user;
    this.hello = this.user.username || "Hello";
    this.service.register1(this.registerParams).subscribe({
      next: (id: number) => localStorage.setItem("currentId", id.toString()),
      error: (err: HttpErrorResponse) => console.error("Registration failed", err)
    });
  }

  onFileSelected(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files.length > 0) {
      this.profilePicture = input.files[0];
    }
  }

  protected readonly onsubmit = onsubmit;
}
