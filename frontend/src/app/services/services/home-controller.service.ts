/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { getPopularPosts } from '../fn/home-controller/get-popular-posts';
import { GetPopularPosts$Params } from '../fn/home-controller/get-popular-posts';
import { getPostsOfFollowing } from '../fn/home-controller/get-posts-of-following';
import { GetPostsOfFollowing$Params } from '../fn/home-controller/get-posts-of-following';
import { login } from '../fn/home-controller/login';
import { Login$Params } from '../fn/home-controller/login';
import { PostDto } from '../models/post-dto';
import { register1 } from '../fn/home-controller/register-1';
import { Register1$Params } from '../fn/home-controller/register-1';

@Injectable({ providedIn: 'root' })
export class HomeControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `register1()` */
  static readonly Register1Path = '/sign-up';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `register1()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  register1$Response(params: Register1$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return register1(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `register1$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  register1(params: Register1$Params, context?: HttpContext): Observable<number> {
    return this.register1$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

  /** Path part for operation `login()` */
  static readonly LoginPath = '/login';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `login()` instead.
   *
   * This method doesn't expect any request body.
   */
  login$Response(params: Login$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return login(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `login$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  login(params: Login$Params, context?: HttpContext): Observable<number> {
    return this.login$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

  /** Path part for operation `getPopularPosts()` */
  static readonly GetPopularPostsPath = '/popular';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getPopularPosts()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPopularPosts$Response(params?: GetPopularPosts$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PostDto>>> {
    return getPopularPosts(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getPopularPosts$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPopularPosts(params?: GetPopularPosts$Params, context?: HttpContext): Observable<Array<PostDto>> {
    return this.getPopularPosts$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<PostDto>>): Array<PostDto> => r.body)
    );
  }

  /** Path part for operation `getPostsOfFollowing()` */
  static readonly GetPostsOfFollowingPath = '/following';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getPostsOfFollowing()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPostsOfFollowing$Response(params?: GetPostsOfFollowing$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PostDto>>> {
    return getPostsOfFollowing(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getPostsOfFollowing$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPostsOfFollowing(params?: GetPostsOfFollowing$Params, context?: HttpContext): Observable<Array<PostDto>> {
    return this.getPostsOfFollowing$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<PostDto>>): Array<PostDto> => r.body)
    );
  }

}
