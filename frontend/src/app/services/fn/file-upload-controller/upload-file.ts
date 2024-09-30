/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import { StrictHttpResponse } from '../../strict-http-response';
import { RequestBuilder } from '../../request-builder';

import { Attachment } from '../../models/attachment';

export interface UploadFile$Params {
      body?: {
'file': Blob;
}
}

export function uploadFile(http: HttpClient, rootUrl: string, params?: UploadFile$Params, context?: HttpContext): Observable<StrictHttpResponse<Attachment>> {
  const rb = new RequestBuilder(rootUrl, uploadFile.PATH, 'post');
  if (params) {
    rb.body(params.body, 'application/json');
  }

  return http.request(
    rb.build({ responseType: 'blob', accept: '*/*', context })
  ).pipe(
    filter((r: any): r is HttpResponse<any> => r instanceof HttpResponse),
    map((r: HttpResponse<any>) => {
      return r as StrictHttpResponse<Attachment>;
    })
  );
}

uploadFile.PATH = '/upload-file';
