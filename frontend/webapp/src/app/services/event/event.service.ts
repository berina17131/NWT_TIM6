import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Http, Headers, Response, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class EventService {

  public API = '//localhost:8080/events';
  public EVENT_API = this.API + '/event';
  result:Array<Object>; 

  constructor(private http: HttpClient) { }

  getEventsByCategory(category: string): Observable<any> {
    return this.http.get(this.EVENT_API + '/' + category);
  }

  getEvent(id: number): Observable<any> {
    return this.http.get(this.EVENT_API + '/' + id);
  }

  deleteEvent(id: number): Observable<any> {
    return this.http.delete(this.EVENT_API + '/' + id);
  }

  createEvent(event: any): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    };

    return this.http.post<Event>(this.EVENT_API, event, httpOptions);
  }

}
