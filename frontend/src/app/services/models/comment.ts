/* tslint:disable */
/* eslint-disable */
import { Attachment } from '../models/attachment';
import { Entry } from '../models/entry';
import { User } from '../models/user';
export interface Comment {
  attachment?: Attachment;
  author?: User;
  commented?: Entry;
  id?: number;
  lastEdit?: string;
  publishedTime?: string;
  text?: string;
}
