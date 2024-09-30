/* tslint:disable */
/* eslint-disable */
import { Id } from '../models/id';
import { User } from '../models/user';
export interface UserSubscription {
  follower?: User;
  id?: Id;
  subscription?: User;
  subscriptionTime?: string;
}
