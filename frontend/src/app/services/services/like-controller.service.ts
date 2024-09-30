/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { addLike } from '../fn/like-controller/add-like';
import { AddLike$Params } from '../fn/like-controller/add-like';
import { addLike1 } from '../fn/like-controller/add-like-1';
import { AddLike1$Params } from '../fn/like-controller/add-like-1';
import { getCommentLikeCount } from '../fn/like-controller/get-comment-like-count';
import { GetCommentLikeCount$Params } from '../fn/like-controller/get-comment-like-count';
import { getPostLikeCount } from '../fn/like-controller/get-post-like-count';
import { GetPostLikeCount$Params } from '../fn/like-controller/get-post-like-count';
import { getPostLikes } from '../fn/like-controller/get-post-likes';
import { GetPostLikes$Params } from '../fn/like-controller/get-post-likes';
import { Like } from '../models/like';
import { unlike } from '../fn/like-controller/unlike';
import { Unlike$Params } from '../fn/like-controller/unlike';
import { unlike1 } from '../fn/like-controller/unlike-1';
import { Unlike1$Params } from '../fn/like-controller/unlike-1';

@Injectable({ providedIn: 'root' })
export class LikeControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `addLike()` */
  static readonly AddLikePath = '/posts/{likedId}/likes';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `addLike()` instead.
   *
   * This method doesn't expect any request body.
   */
  addLike$Response(params?: AddLike$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return addLike(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `addLike$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  addLike(params?: AddLike$Params, context?: HttpContext): Observable<void> {
    return this.addLike$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `unlike()` */
  static readonly UnlikePath = '/posts/{likedId}/likes';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `unlike()` instead.
   *
   * This method doesn't expect any request body.
   */
  unlike$Response(params: Unlike$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return unlike(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `unlike$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  unlike(params: Unlike$Params, context?: HttpContext): Observable<void> {
    return this.unlike$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `addLike1()` */
  static readonly AddLike1Path = '/posts/{postId}/comments/{likedId}/likes';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `addLike1()` instead.
   *
   * This method doesn't expect any request body.
   */
  addLike1$Response(params: AddLike1$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return addLike1(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `addLike1$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  addLike1(params: AddLike1$Params, context?: HttpContext): Observable<void> {
    return this.addLike1$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `unlike1()` */
  static readonly Unlike1Path = '/posts/{postId}/comments/{likedId}/likes';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `unlike1()` instead.
   *
   * This method doesn't expect any request body.
   */
  unlike1$Response(params: Unlike1$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return unlike1(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `unlike1$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  unlike1(params: Unlike1$Params, context?: HttpContext): Observable<void> {
    return this.unlike1$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `getPostLikes()` */
  static readonly GetPostLikesPath = '/posts/{postId}/likes';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getPostLikes()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPostLikes$Response(params: GetPostLikes$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<Like>>> {
    return getPostLikes(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getPostLikes$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPostLikes(params: GetPostLikes$Params, context?: HttpContext): Observable<Array<Like>> {
    return this.getPostLikes$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<Like>>): Array<Like> => r.body)
    );
  }

  /** Path part for operation `getPostLikeCount()` */
  static readonly GetPostLikeCountPath = '/posts/{postId}/likes/count';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getPostLikeCount()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPostLikeCount$Response(params: GetPostLikeCount$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return getPostLikeCount(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getPostLikeCount$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPostLikeCount(params: GetPostLikeCount$Params, context?: HttpContext): Observable<number> {
    return this.getPostLikeCount$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

  /** Path part for operation `getCommentLikeCount()` */
  static readonly GetCommentLikeCountPath = '/posts/{postId}/comments/{commentId}/likes/count';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getCommentLikeCount()` instead.
   *
   * This method doesn't expect any request body.
   */
  getCommentLikeCount$Response(params: GetCommentLikeCount$Params, context?: HttpContext): Observable<StrictHttpResponse<number>> {
    return getCommentLikeCount(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getCommentLikeCount$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getCommentLikeCount(params: GetCommentLikeCount$Params, context?: HttpContext): Observable<number> {
    return this.getCommentLikeCount$Response(params, context).pipe(
      map((r: StrictHttpResponse<number>): number => r.body)
    );
  }

}
