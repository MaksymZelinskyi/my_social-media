import { Injectable } from '@angular/core';
import {FileUploadControllerService} from "../services/file-upload-controller.service";
import {HttpContext} from "@angular/common/http";
import {Attachment} from "../models/attachment";

@Injectable({
  providedIn: 'root'
})
export class FileUploadService {


  constructor(private controller: FileUploadControllerService,
              private context: HttpContext
  ) {

  }

  uploadFile(file: File): Attachment{
    var attachment: Attachment = {}
    this.controller.uploadFile({body: {file: file}}, this.context).subscribe(
      (next) => {
        attachment = next
      }
    )
    return attachment
  }
}
