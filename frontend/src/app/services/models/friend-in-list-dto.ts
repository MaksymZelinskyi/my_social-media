/* tslint:disable */
/* eslint-disable */
import { Attachment } from '../models/attachment';
export interface FriendInListDto {
  id?: number;
  profilePicture?: Attachment;
  subscribed?: boolean;
  subscriptionTime?: string;
  username?: string;
}
