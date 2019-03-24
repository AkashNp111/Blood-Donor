import { Injectable } from '@angular/core';
import { User } from './user/user.info';
import { Observable, of, BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  private user  = new BehaviorSubject<User>(new User());
  currentUser = this.user.asObservable();

  constructor() { }

  saveUser(user : User) : void
  {
    this.user.next(user);
  }

}


