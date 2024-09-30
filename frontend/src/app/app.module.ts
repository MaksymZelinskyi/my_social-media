import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClient, HttpClientModule, HttpContext} from "@angular/common/http";
import { LoginComponent } from './pages/login/login.component';
import {FormsModule} from "@angular/forms";
import { FileUploadService } from './services/file-upload/file-upload.service';
import {RegisterComponent} from "./pages/register/register.component";
import { FeedComponent } from './pages/feed/feed.component';
import { CommentComponent } from './pages/comment/comment.component';
import {InfiniteScrollDirective} from "ngx-infinite-scroll";
import { AddpostComponent } from './addpost/addpost.component';
import { PostComponent } from './post/post.component';
import { ProfileComponent } from './pages/profile/profile.component';
import {FaIconComponent} from "@fortawesome/angular-fontawesome";
import { CurrentProfileComponent } from './pages/current-profile/current-profile.component';
import { HomeComponent } from './pages/home/home.component';
import { SearchComponent } from './pages/search/search.component';
import { FriendInListComponent } from './friend-in-list/friend-in-list.component';
import {FriendsComponent} from "./friends/friends.component";
import { UsersComponent } from './users/users.component';
import { UserInListComponent } from './user-in-list/user-in-list.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    FeedComponent,
    CommentComponent,
    AddpostComponent,
    PostComponent,
    ProfileComponent,
    PostComponent,
    CurrentProfileComponent,
    HomeComponent,
    SearchComponent,
    FriendInListComponent,
    FriendsComponent,
    UsersComponent,
    UserInListComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    InfiniteScrollDirective,
    FaIconComponent
  ],
  providers: [
    {provide: HttpClient, useClass: HttpClient},
    {provide: HttpContext, useClass: HttpContext},
    {provide: FileUploadService, useClass: FileUploadService}
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
