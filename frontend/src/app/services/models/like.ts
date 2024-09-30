/* tslint:disable */
/* eslint-disable */
import { Entry } from '../models/entry';
import { Id } from '../models/id';
import { User } from '../models/user';
export interface Like {
  entry?: Entry;
  id?: Id;
  time?: string;
  user?: User;
}
