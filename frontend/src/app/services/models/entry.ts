/* tslint:disable */
/* eslint-disable */
import { Attachment } from '../models/attachment';
import { User } from '../models/user';
export interface Entry {
  attachment?: Attachment;
  author?: User;
  id?: number;
  lastEdit?: string;
  publishedTime?: string;
  text?: string;
}
