import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { DataService } from '../data.service';
import { User } from '../user/user.info';
import { Router } from '@angular/router';

@Component({
  selector: 'app-edituser',
  templateUrl: './edituser.component.html',
  styleUrls: ['./edituser.component.css']
})
export class EdituserComponent implements OnInit {
private user : User;

  constructor(private userService : UserService, 
    private dataService : DataService,
    private router : Router) { }

  ngOnInit() {
    this.dataService.currentUser.subscribe(user => this.user = user);
  }

  update(user : User) : void
  {
    this.userService.updateUser(user).subscribe(user => this.user = user);
    this.router.navigate(["/users"]);
  }

}
