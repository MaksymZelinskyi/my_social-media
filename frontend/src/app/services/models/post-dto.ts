/* tslint:disable */
/* eslint-disable */
import { Post } from '../models/post';
export interface PostDto {
  likeCount?: number;
  liked?: boolean;
  post?: Post;
}
