import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap, delay } from 'rxjs/operators';
import { Login } from './login/user.login';
import { UserService } from './user.service';
import { User } from './user/user.info';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})


export class LoginService {
  loginUrl : string = 'http://localhost:9999/blood-donors/login';
  constructor(private http: HttpClient ,private  userService : UserService) { }

  doLogin(login : Login ) : Observable<User>
  {
    return this.http.post<User>(this.loginUrl,login,httpOptions).
    pipe
    (
      delay(1000),
      tap(_ => ' User Login Successful !!!'),
      catchError(this.userService.handleError<User>('doLogin()'))
    );
  }
}
