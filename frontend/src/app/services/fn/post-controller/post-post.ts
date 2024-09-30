/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Post } from '../../models/post';

export interface PostPost$Params {
      body: Post
}

export function postPost(http: HttpClient, rootUrl: string, params: PostPost$Params, context?: HttpContext): Observable<StrictHttpResponse<Post>> {
  const rb = new RequestBuilder(rootUrl, postPost.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Post>;
    })
  );
}

postPost.PATH = '/posts';
