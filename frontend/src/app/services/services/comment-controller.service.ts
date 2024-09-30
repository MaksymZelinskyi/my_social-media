/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { addComment } from '../fn/comment-controller/add-comment';
import { AddComment$Params } from '../fn/comment-controller/add-comment';
import { addComment1 } from '../fn/comment-controller/add-comment-1';
import { AddComment1$Params } from '../fn/comment-controller/add-comment-1';
import { Comment } from '../models/comment';
import { deletePostComment } from '../fn/comment-controller/delete-post-comment';
import { DeletePostComment$Params } from '../fn/comment-controller/delete-post-comment';
import { deletePostComment1 } from '../fn/comment-controller/delete-post-comment-1';
import { DeletePostComment1$Params } from '../fn/comment-controller/delete-post-comment-1';
import { getPostComment } from '../fn/comment-controller/get-post-comment';
import { GetPostComment$Params } from '../fn/comment-controller/get-post-comment';
import { getPostComments } from '../fn/comment-controller/get-post-comments';
import { GetPostComments$Params } from '../fn/comment-controller/get-post-comments';
import { updateComment } from '../fn/comment-controller/update-comment';
import { UpdateComment$Params } from '../fn/comment-controller/update-comment';
import { updateComment1 } from '../fn/comment-controller/update-comment-1';
import { UpdateComment1$Params } from '../fn/comment-controller/update-comment-1';

@Injectable({ providedIn: 'root' })
export class CommentControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `updateComment()` */
  static readonly UpdateCommentPath = '/posts/{postId}/comments/{commented_id}/responses/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateComment()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateComment$Response(params: UpdateComment$Params, context?: HttpContext): Observable<StrictHttpResponse<Comment>> {
    return updateComment(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateComment$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateComment(params: UpdateComment$Params, context?: HttpContext): Observable<Comment> {
    return this.updateComment$Response(params, context).pipe(
      map((r: StrictHttpResponse<Comment>): Comment => r.body)
    );
  }

  /** Path part for operation `deletePostComment()` */
  static readonly DeletePostCommentPath = '/posts/{postId}/comments/{commented_id}/responses/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deletePostComment()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePostComment$Response(params: DeletePostComment$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deletePostComment(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deletePostComment$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePostComment(params: DeletePostComment$Params, context?: HttpContext): Observable<void> {
    return this.deletePostComment$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `updateComment1()` */
  static readonly UpdateComment1Path = '/posts/{commented_Id}/comments/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updateComment1()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateComment1$Response(params: UpdateComment1$Params, context?: HttpContext): Observable<StrictHttpResponse<Comment>> {
    return updateComment1(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updateComment1$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updateComment1(params: UpdateComment1$Params, context?: HttpContext): Observable<Comment> {
    return this.updateComment1$Response(params, context).pipe(
      map((r: StrictHttpResponse<Comment>): Comment => r.body)
    );
  }

  /** Path part for operation `deletePostComment1()` */
  static readonly DeletePostComment1Path = '/posts/{commented_Id}/comments/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deletePostComment1()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePostComment1$Response(params: DeletePostComment1$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deletePostComment1(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deletePostComment1$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePostComment1(params: DeletePostComment1$Params, context?: HttpContext): Observable<void> {
    return this.deletePostComment1$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `addComment()` */
  static readonly AddCommentPath = '/posts/{commented_id}/comments';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `addComment()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  addComment$Response(params: AddComment$Params, context?: HttpContext): Observable<StrictHttpResponse<Comment>> {
    return addComment(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `addComment$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  addComment(params: AddComment$Params, context?: HttpContext): Observable<Comment> {
    return this.addComment$Response(params, context).pipe(
      map((r: StrictHttpResponse<Comment>): Comment => r.body)
    );
  }

  /** Path part for operation `addComment1()` */
  static readonly AddComment1Path = '/posts/{postId}/comments/{commented_id}/responses';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `addComment1()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  addComment1$Response(params: AddComment1$Params, context?: HttpContext): Observable<StrictHttpResponse<Comment>> {
    return addComment1(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `addComment1$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  addComment1(params: AddComment1$Params, context?: HttpContext): Observable<Comment> {
    return this.addComment1$Response(params, context).pipe(
      map((r: StrictHttpResponse<Comment>): Comment => r.body)
    );
  }

  /** Path part for operation `getPostComments()` */
  static readonly GetPostCommentsPath = '/posts/{postId}/comments';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getPostComments()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPostComments$Response(params: GetPostComments$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<Comment>>> {
    return getPostComments(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getPostComments$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPostComments(params: GetPostComments$Params, context?: HttpContext): Observable<Array<Comment>> {
    return this.getPostComments$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<Comment>>): Array<Comment> => r.body)
    );
  }

  /** Path part for operation `getPostComment()` */
  static readonly GetPostCommentPath = '/posts/{postId}/comments/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getPostComment()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPostComment$Response(params: GetPostComment$Params, context?: HttpContext): Observable<StrictHttpResponse<Comment>> {
    return getPostComment(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getPostComment$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPostComment(params: GetPostComment$Params, context?: HttpContext): Observable<Comment> {
    return this.getPostComment$Response(params, context).pipe(
      map((r: StrictHttpResponse<Comment>): Comment => r.body)
    );
  }

}
