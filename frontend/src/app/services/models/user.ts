/* tslint:disable */
/* eslint-disable */
import { Attachment } from '../models/attachment';
import { Like } from '../models/like';
import { PersonalInfo } from '../models/personal-info';
import { Post } from '../models/post';
import { UserSubscription } from '../models/user-subscription';
export interface User {
  email?: string;
  followers?: Array<UserSubscription>;
  id?: number;
  likes?: Array<Like>;
  password?: string;
  personalInfo?: PersonalInfo;
  posts?: Array<Post>;
  profilePicture?: Attachment;
  registrationDate?: string;
  roles?: Array<string>;
  subscriptions?: Array<UserSubscription>;
  username?: string;
}
