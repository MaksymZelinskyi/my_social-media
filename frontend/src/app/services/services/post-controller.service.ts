/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { deletePost } from '../fn/post-controller/delete-post';
import { DeletePost$Params } from '../fn/post-controller/delete-post';
import { getAllPosts } from '../fn/post-controller/get-all-posts';
import { GetAllPosts$Params } from '../fn/post-controller/get-all-posts';
import { getPostById } from '../fn/post-controller/get-post-by-id';
import { GetPostById$Params } from '../fn/post-controller/get-post-by-id';
import { Post } from '../models/post';
import { PostDto } from '../models/post-dto';
import { postPost } from '../fn/post-controller/post-post';
import { PostPost$Params } from '../fn/post-controller/post-post';
import { updatePost } from '../fn/post-controller/update-post';
import { UpdatePost$Params } from '../fn/post-controller/update-post';

@Injectable({ providedIn: 'root' })
export class PostControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `getPostById()` */
  static readonly GetPostByIdPath = '/posts/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getPostById()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPostById$Response(params: GetPostById$Params, context?: HttpContext): Observable<StrictHttpResponse<Post>> {
    return getPostById(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getPostById$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getPostById(params: GetPostById$Params, context?: HttpContext): Observable<Post> {
    return this.getPostById$Response(params, context).pipe(
      map((r: StrictHttpResponse<Post>): Post => r.body)
    );
  }

  /** Path part for operation `updatePost()` */
  static readonly UpdatePostPath = '/posts/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `updatePost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updatePost$Response(params: UpdatePost$Params, context?: HttpContext): Observable<StrictHttpResponse<Post>> {
    return updatePost(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `updatePost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  updatePost(params: UpdatePost$Params, context?: HttpContext): Observable<Post> {
    return this.updatePost$Response(params, context).pipe(
      map((r: StrictHttpResponse<Post>): Post => r.body)
    );
  }

  /** Path part for operation `deletePost()` */
  static readonly DeletePostPath = '/posts/{id}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `deletePost()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePost$Response(params: DeletePost$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return deletePost(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `deletePost$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  deletePost(params: DeletePost$Params, context?: HttpContext): Observable<void> {
    return this.deletePost$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `getAllPosts()` */
  static readonly GetAllPostsPath = '/posts';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getAllPosts()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllPosts$Response(params?: GetAllPosts$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PostDto>>> {
    return getAllPosts(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getAllPosts$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getAllPosts(params?: GetAllPosts$Params, context?: HttpContext): Observable<Array<PostDto>> {
    return this.getAllPosts$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<PostDto>>): Array<PostDto> => r.body)
    );
  }

  /** Path part for operation `postPost()` */
  static readonly PostPostPath = '/posts';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `postPost()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  postPost$Response(params: PostPost$Params, context?: HttpContext): Observable<StrictHttpResponse<Post>> {
    return postPost(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `postPost$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  postPost(params: PostPost$Params, context?: HttpContext): Observable<Post> {
    return this.postPost$Response(params, context).pipe(
      map((r: StrictHttpResponse<Post>): Post => r.body)
    );
  }

}
