/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { FriendInListDto } from '../models/friend-in-list-dto';
import { getFollowers } from '../fn/subscription-controller/get-followers';
import { GetFollowers$Params } from '../fn/subscription-controller/get-followers';
import { getSubscriptions } from '../fn/subscription-controller/get-subscriptions';
import { GetSubscriptions$Params } from '../fn/subscription-controller/get-subscriptions';
import { subscribe } from '../fn/subscription-controller/subscribe';
import { Subscribe$Params } from '../fn/subscription-controller/subscribe';
import { unsubscribe } from '../fn/subscription-controller/unsubscribe';
import { Unsubscribe$Params } from '../fn/subscription-controller/unsubscribe';

@Injectable({ providedIn: 'root' })
export class SubscriptionControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `subscribe()` */
  static readonly SubscribePath = '/subscriptions/{userId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `subscribe()` instead.
   *
   * This method doesn't expect any request body.
   */
  subscribe$Response(params: Subscribe$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return subscribe(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `subscribe$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  subscribe(params: Subscribe$Params, context?: HttpContext): Observable<void> {
    return this.subscribe$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `unsubscribe()` */
  static readonly UnsubscribePath = '/subscriptions/{userId}';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `unsubscribe()` instead.
   *
   * This method doesn't expect any request body.
   */
  unsubscribe$Response(params: Unsubscribe$Params, context?: HttpContext): Observable<StrictHttpResponse<void>> {
    return unsubscribe(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `unsubscribe$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  unsubscribe(params: Unsubscribe$Params, context?: HttpContext): Observable<void> {
    return this.unsubscribe$Response(params, context).pipe(
      map((r: StrictHttpResponse<void>): void => r.body)
    );
  }

  /** Path part for operation `getSubscriptions()` */
  static readonly GetSubscriptionsPath = '/users/{userId}/subscriptions';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getSubscriptions()` instead.
   *
   * This method doesn't expect any request body.
   */
  getSubscriptions$Response(params: GetSubscriptions$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<FriendInListDto>>> {
    return getSubscriptions(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getSubscriptions$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getSubscriptions(params: GetSubscriptions$Params, context?: HttpContext): Observable<Array<FriendInListDto>> {
    return this.getSubscriptions$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<FriendInListDto>>): Array<FriendInListDto> => r.body)
    );
  }

  /** Path part for operation `getFollowers()` */
  static readonly GetFollowersPath = '/users/{userId}/followers';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `getFollowers()` instead.
   *
   * This method doesn't expect any request body.
   */
  getFollowers$Response(params: GetFollowers$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<FriendInListDto>>> {
    return getFollowers(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `getFollowers$Response()` instead.
   *
   * This method doesn't expect any request body.
   */
  getFollowers(params: GetFollowers$Params, context?: HttpContext): Observable<Array<FriendInListDto>> {
    return this.getFollowers$Response(params, context).pipe(
      map((r: StrictHttpResponse<Array<FriendInListDto>>): Array<FriendInListDto> => r.body)
    );
  }

}
