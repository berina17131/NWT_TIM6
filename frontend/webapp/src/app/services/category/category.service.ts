import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Http, Headers, Response, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  public API = '//localhost:8080/events';
  public CATEGORY_API = this.API + '/category';
  result: Array<Object>; 

  constructor(private http: HttpClient) { }

  getAllCategory(): Observable<any> {
    return this.http.get(this.CATEGORY_API + '/all');
  }
  
}
