import { Component, OnInit } from '@angular/core';
import { User } from '../user/user.info';
import { UserService } from '../user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';
import { Address } from '../user/user.address';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  user : User;

  constructor(private userService : UserService ,
     private router : Router ,
     private dataService : DataService) { }

  ngOnInit() {

    this.user = new User();
    this.user.address = new Address();
  }

    register(user : User) : void
    {
        this.userService.saveUser(user).subscribe(user => this.user = user);
        this.dataService.saveUser(this.user);
        this.router.navigate(["/users"]);
    }

}
