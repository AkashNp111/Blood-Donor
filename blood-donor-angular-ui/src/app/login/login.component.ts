import { Component, OnInit } from '@angular/core';
import { Login } from './user.login';
import { User } from '../user/user.info';
import { LoginService } from '../login.service';
import { Router, NavigationExtras } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  
  loginData : Login;
  user : User;
  errorMsg : string = "";
  
  

  constructor(private loginService : LoginService 
    ,private dataService : DataService,
    private router :Router) { }

  ngOnInit() {
    this.loginData = new Login();
  }

  doLogin(loginData : Login) : void
  {

  
    this.loginService.doLogin(loginData).subscribe(user => this.user = user);
     if(this.user == null)
     {
      this.errorMsg = "Invalid UserId or Password";
      }else
     {
      this.errorMsg = "";
      this.dataService.saveUser(this.user);
      this.router.navigate(["/users"]);
     } 

  }

}
