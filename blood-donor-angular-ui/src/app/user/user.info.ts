import {  Address } from './user.address'
import { Role } from './user.role';
import { Feedback } from './user.feedback';

export class User  {
  loginId: string;
  firstName: string;
  lastName: string;
  emailId: string;
  mobileNo: number;
  bloodGroup:string;
  address: Address;
  roleSet: Role[];
  postedFeedbacks: Feedback[];
  donorsSet : Feedback[];
  
  constructor() { }


}
