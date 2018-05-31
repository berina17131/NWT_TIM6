import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Http, Headers, Response, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class GradeService {

  public API = '//localhost:8080/interactions';
  public GRADE_API = this.API + '/grade';
  result: Array<Object>; 

  constructor(private http: HttpClient) { }

  getAverageGrade(id: number): Observable<any> {
    return this.http.get(this.GRADE_API + '/' + id);
  }

}
