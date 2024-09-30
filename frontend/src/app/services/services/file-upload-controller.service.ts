/* tslint:disable */
/* eslint-disable */
import { HttpClient, HttpContext } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { BaseService } from '../base-service';
import { ApiConfiguration } from '../api-configuration';
import { StrictHttpResponse } from '../strict-http-response';

import { Attachment } from '../models/attachment';
import { uploadFile } from '../fn/file-upload-controller/upload-file';
import { UploadFile$Params } from '../fn/file-upload-controller/upload-file';

@Injectable({ providedIn: 'root' })
export class FileUploadControllerService extends BaseService {
  constructor(config: ApiConfiguration, http: HttpClient) {
    super(config, http);
  }

  /** Path part for operation `uploadFile()` */
  static readonly UploadFilePath = '/upload-file';

  /**
   * This method provides access to the full `HttpResponse`, allowing access to response headers.
   * To access only the response body, use `uploadFile()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  uploadFile$Response(params?: UploadFile$Params, context?: HttpContext): Observable<StrictHttpResponse<Attachment>> {
    return uploadFile(this.http, this.rootUrl, params, context);
  }

  /**
   * This method provides access only to the response body.
   * To access the full response (for headers, for example), `uploadFile$Response()` instead.
   *
   * This method sends `application/json` and handles request body of type `application/json`.
   */
  uploadFile(params?: UploadFile$Params, context?: HttpContext): Observable<Attachment> {
    return this.uploadFile$Response(params, context).pipe(
      map((r: StrictHttpResponse<Attachment>): Attachment => r.body)
    );
  }

}
