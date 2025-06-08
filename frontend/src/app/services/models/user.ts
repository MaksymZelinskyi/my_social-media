// user.model.ts

import { Attachment } from '../models/attachment';
import { Like } from '../models/like';
import { PersonalInfo } from '../models/personal-info';
import { Post } from '../models/post';
import { UserSubscription } from '../models/user-subscription';

export class User {
  email: string = '';
  followers: Array<UserSubscription> = [];
  id: number = 0;
  likes: Array<Like> = [];
  password: string = '';
  personalInfo: PersonalInfo = {
    firstName: '',
    lastName: '',
    birthDate: undefined,
    gender: 'CONCEALED'
  };
  posts: Array<Post> = [];
  profilePicture?: Attachment;
  registrationDate: string = '';
  roles: Array<string> = [];
  subscriptions: Array<UserSubscription> = [];
  username: string = '';
}
