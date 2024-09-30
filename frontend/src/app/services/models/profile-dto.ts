/* tslint:disable */
/* eslint-disable */
import { Attachment } from '../models/attachment';
export interface ProfileDto {
  followersCount?: number;
  id?: number;
  profilePicture?: Attachment;
  subscribed?: boolean;
  subscriptionsCount?: number;
  username?: string;
}
