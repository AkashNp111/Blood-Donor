import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { UserComponent } from './user/user.component';
import { User } from './user/user.info'
import { Search } from './user/user.search';
import { Feedback } from './user/user.feedback';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

   feedbacks : string = 'http://localhost:9999/blood-donors/feedbacks';
  
  constructor(private http : HttpClient) { }

  postFeedback(feedBack : Feedback) : Observable<Feedback>
  {
    return this.http.post<Feedback>(this.feedbacks,feedBack,httpOptions).
      pipe
      (
        tap(_ => 'Fetched all the Users'),
        catchError(this.handleError<Feedback>('getUsers()',[]))
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
