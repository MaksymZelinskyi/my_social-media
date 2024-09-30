/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { deleteUser } from '../fn/user-controller/delete-user';
import { DeleteUser$Params } from '../fn/user-controller/delete-user';
import { getCurrent } from '../fn/user-controller/get-current';
import { GetCurrent$Params } from '../fn/user-controller/get-current';
import { getPosts } from '../fn/user-controller/get-posts';
import { GetPosts$Params } from '../fn/user-controller/get-posts';
import { getUser } from '../fn/user-controller/get-user';
import { GetUser$Params } from '../fn/user-controller/get-user';
import { PostDto } from '../models/post-dto';
import { ProfileDto } from '../models/profile-dto';
import { register } from '../fn/user-controller/register';
import { Register$Params } from '../fn/user-controller/register';
import { updateUser } from '../fn/user-controller/update-user';
import { UpdateUser$Params } from '../fn/user-controller/update-user';
import { User } from '../models/user';

@Injectable({ providedIn: 'root' })
export class UserControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `getUser()` */
  static readonly GetUserPath = '/users/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getUser()` instead.
   *
   * This method doesn't expect any request body.
   */
  getUser$Response(params: GetUser$Params, context?: HttpContext): Observable<StrictHttpResponse<ProfileDto>> {
    return getUser(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getUser$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getUser(params: GetUser$Params, context?: HttpContext): Observable<ProfileDto> {
    return this.getUser$Response(params, context).pipe(
      map((r: StrictHttpResponse<ProfileDto>): ProfileDto => r.body)
    );
  }

  /** Path part for operation `updateUser()` */
  static readonly UpdateUserPath = '/users/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateUser()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateUser$Response(params: UpdateUser$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return updateUser(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateUser$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateUser(params: UpdateUser$Params, context?: HttpContext): Observable<void> {
    return this.updateUser$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `deleteUser()` */
  static readonly DeleteUserPath = '/users/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deleteUser()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteUser$Response(params: DeleteUser$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deleteUser(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deleteUser$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deleteUser(params: DeleteUser$Params, context?: HttpContext): Observable<void> {
    return this.deleteUser$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `register()` */
  static readonly RegisterPath = '/users';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `register()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  register$Response(params: Register$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return register(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `register$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  register(params: Register$Params, context?: HttpContext): Observable<void> {
    return this.register$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `getPosts()` */
  static readonly GetPostsPath = '/users/{id}/posts';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getPosts()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPosts$Response(params: GetPosts$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PostDto>>> {
    return getPosts(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getPosts$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPosts(params: GetPosts$Params, context?: HttpContext): Observable<Array<PostDto>> {
    return this.getPosts$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<PostDto>>): Array<PostDto> => r.body)
    );
  }

  /** Path part for operation `getCurrent()` */
  static readonly GetCurrentPath = '/users/current';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getCurrent()` instead.
   *
   * This method doesn't expect any request body.
   */
  getCurrent$Response(params?: GetCurrent$Params, context?: HttpContext): Observable<StrictHttpResponse<User>> {
    return getCurrent(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getCurrent$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getCurrent(params?: GetCurrent$Params, context?: HttpContext): Observable<User> {
    return this.getCurrent$Response(params, context).pipe(
      map((r: StrictHttpResponse<User>): User => r.body)
    );
  }

}
