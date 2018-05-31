import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Http, Headers, Response, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs';
import { TokenStorage } from '../../core/token.storage';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  public API = '//localhost:8080/users';
  public USER_API = this.API + '/user';

  constructor(private http: HttpClient) { }

  /*public httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Authorization':  'Bearer ' + TokenStorage.getToken()
    })
  };*/

  getAllUsers(): Observable<any> {
    return this.http.get(this.USER_API + '/all');
  }

  getUserById(id: number): Observable<any> {
    return this.http.get(this.USER_API + '?id=' + id);
  }

  deleteUserById(id: number): Observable<any> {
    return this.http.delete(this.USER_API + '/delete/' + id);
  }
  
}
