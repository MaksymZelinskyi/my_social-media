/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Like } from '../../models/like';

export interface GetPostLikes$Params {
  postId: number;
  oldestLikeTime?: string;
}

export function getPostLikes(http: HttpClient, rootUrl: string, params: GetPostLikes$Params, context?: HttpContext): Observable<StrictHttpResponse<Array<Like>>> {
  const rb = new RequestBuilder(rootUrl, getPostLikes.PATH, 'get');
  if (params) {
    rb.path('postId', params.postId, {});
    rb.query('oldestLikeTime', params.oldestLikeTime, {});
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Array<Like>>;
    })
  );
}

getPostLikes.PATH = '/posts/{postId}/likes';
