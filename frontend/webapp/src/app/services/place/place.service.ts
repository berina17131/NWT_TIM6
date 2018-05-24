import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Http, Headers, Response, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class PlaceService {

  public API = '//localhost:8080/places';
  public PLACE_API = this.API + '/place';
  result:Array<Object>; 

  constructor(private http: HttpClient) { }

  getAllPlaces(): Observable<any> {
    return this.http.get(this.PLACE_API + '/all');
  }

  deletePlace(id: number): Observable<any> {
    return this.http.delete(this.PLACE_API + '/' + id);
  }
}
