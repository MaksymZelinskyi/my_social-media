/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { PostDto } from '../models/post-dto';
import { searchPosts } from '../fn/search-controller/search-posts';
import { SearchPosts$Params } from '../fn/search-controller/search-posts';
import { searchUsers } from '../fn/search-controller/search-users';
import { SearchUsers$Params } from '../fn/search-controller/search-users';
import { UserInListDto } from '../models/user-in-list-dto';

@Injectable({ providedIn: 'root' })
export class SearchControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `searchUsers()` */
  static readonly SearchUsersPath = '/search/users';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `searchUsers()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  searchUsers$Response(params: SearchUsers$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<UserInListDto>>> {
    return searchUsers(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `searchUsers$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  searchUsers(params: SearchUsers$Params, context?: HttpContext): Observable<Array<UserInListDto>> {
    return this.searchUsers$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<UserInListDto>>): Array<UserInListDto> => r.body)
    );
  }

  /** Path part for operation `searchPosts()` */
  static readonly SearchPostsPath = '/search/posts';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `searchPosts()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  searchPosts$Response(params: SearchPosts$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<PostDto>>> {
    return searchPosts(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `searchPosts$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  searchPosts(params: SearchPosts$Params, context?: HttpContext): Observable<Array<PostDto>> {
    return this.searchPosts$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<PostDto>>): Array<PostDto> => r.body)
    );
  }

}
