import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { UserComponent } from './user/user.component';
import { User } from './user/user.info'
import { Search } from './user/user.search';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class UserService {

  usersUrl  : string = 'http://localhost:9999/blood-donors/users';
  searchUrl : string = 'http://localhost:9999/blood-donors/search';
  
  constructor(private http : HttpClient) { }

  getUsers() : Observable<User[]>
  {
    return this.http.get<User[]>(this.usersUrl).
      pipe
      (
        tap(_ => 'Fetched all the Users'),
        catchError(this.handleError<User[]>('getUsers()',[]))
      );
  }

  searchUsersByCity(search : Search) : Observable<User[]>
  {
  
    if(search.city == undefined || search.city == null || search.city.trim().length == 0)
    {
      return this.getUsers();
    }
    
    return this.http.post<User[]>(this.searchUrl,search,httpOptions).
      pipe
      (
        tap(_ => 'Fetched all the Users by city'),
        catchError(this.handleError<User[]>('getUsersByCity({city})',[]))
      );
  }

  saveUser(user : User) : Observable<User>
  {
    return this.http.post<User>(this.usersUrl, user , httpOptions).
      pipe
      (
        tap(_ => 'save User '),
        catchError(this.handleError<User>('saveUSer()'))
      );
  }

  updateUser(user : User) : Observable<User>
  {
    return this.http.put<User>(this.usersUrl, user , httpOptions).
      pipe
      (
        tap(_ => 'update User '),
        catchError(this.handleError<User>('updateUser()'))
      );
  }

  getUserById(id : string) : Observable<User>
  {
    const url = `${this.usersUrl}/${id}`;

    return this.http.get<User>(url).
      pipe
      (
        tap(_ => 'Fetched User by id :{id} '),
        catchError(this.handleError<User>('getUserById({id})'))
      );
  }

  deleteUserById(id : string) : Observable<User>
  {
    const url = `${this.usersUrl}/${id}`;
    console.log("****"+url);
   return this.http.delete<User>(url,httpOptions).
      pipe
      (
        tap(_ => 'Deleted User by id :{id} '),
        catchError(this.handleError<User>('deleteUserById({id})'))
      );
  }

   /**
   * Handle Http operation that failed.
   * Let the app continue.
   * @param operation - name of the operation that failed
   * @param result - optional value to return as the observable result
   */
   handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
