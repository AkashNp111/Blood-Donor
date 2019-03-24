import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { UserComponent } from './user/user.component';
import { User } from './user/user.info'



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})

export class UserService {

  usersUrl : string = 'http://localhost:9999/blood-donors/users';
  
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

  deleteUserById(id : string) : void
  {
    const url = `${this.usersUrl}/${id}`;

    this.http.delete(url).
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
