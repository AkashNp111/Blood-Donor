import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from './user.info';

import { DataService } from '../data.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users : User[];
  userInfo : User;
  constructor(
       private userService : UserService,
       private dataService : DataService) { }
    
  ngOnInit() {
    this.dataService.currentUser.subscribe(user => this.userInfo = user);
    console.log("****"+this.userInfo);
  }

    getUsers() : void
    {
      this.userService.getUsers().subscribe(users=> this.users = users);
    }
}
