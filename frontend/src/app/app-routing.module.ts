import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginComponent} from "./pages/login/login.component";
import {RegisterComponent} from "./pages/register/register.component";
import {AddpostComponent} from "./addpost/addpost.component";
import {HomeComponent} from "./pages/home/home.component";
import {SearchComponent} from "./pages/search/search.component";
import {ProfileComponent} from "./pages/profile/profile.component";
import {FriendsComponent} from "./friends/friends.component";

const routes: Routes = [
  {path: "login", component: LoginComponent},
  {path: "sign-up", component: RegisterComponent},
  {path: "", component: HomeComponent},
  {path: "add-post", component: AddpostComponent},
  {path: "search", component: SearchComponent},
  {path: "users/:id", component: ProfileComponent},
  {path: "users/:id/subscriptions", component: FriendsComponent},
  {path: "users/:id/followers", component: FriendsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
