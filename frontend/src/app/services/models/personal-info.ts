/* tslint:disable */
/* eslint-disable */
import { Birthday } from '../models/birthday';
export interface PersonalInfo {
  birthDate?: Birthday;
  firstName?: string;
  gender?: 'MALE' | 'FEMALE' | 'CONCEALED';
  lastName?: string;
}
