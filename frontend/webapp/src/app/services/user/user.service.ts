import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Http, Headers, Response, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  public API = '//localhost:8080/users';
  public USER_API = this.API + '/user';

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<any> {
    return this.http.get(this.USER_API + '/all');
  }

  getUserById(id: number): Observable<any> {
    return this.http.get(this.USER_API + '?=id' + id);
  }
  
}
