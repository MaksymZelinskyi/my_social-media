/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { FriendInListDto } from '../../models/friend-in-list-dto';

export interface GetFollowers$Params {
  userId: number;
  previousSubscriptionTime?: string;
  count: number;
}

export function getFollowers(http: HttpClient, rootUrl: string, params: GetFollowers$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<FriendInListDto>>> {
  const rb = new RequestBuilder(rootUrl, getFollowers.PATH, 'get');
  if (params) {
    rb.path('userId', params.userId, {});
    rb.query('previousSubscriptionTime', params.previousSubscriptionTime, {});
    rb.query('count', params.count, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<FriendInListDto>>;
    })
  );
}

getFollowers.PATH = '/users/{userId}/followers';
