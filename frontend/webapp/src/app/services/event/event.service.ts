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

  getAllEvents(): Observable<any> {
    return this.http.get(this.EVENT_API + '/all');
  }

}
