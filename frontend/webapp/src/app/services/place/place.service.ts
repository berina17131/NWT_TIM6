import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Observable } from 'rxjs';
import { Place } from './Place';

@Injectable({
  providedIn: 'root'
})

export class PlaceService {

  public API = '//localhost:8080/places';
  public PLACE_API = this.API + '/place';
  public ADDRESS_API = this.API + '/address/all';

  result: Array<Object>;

  constructor(private http: HttpClient) { }

  getAllPlaces(): Observable<any> {
    return this.http.get(this.PLACE_API + '/all');
  }

  getAllAddresses(): Observable<any> {
    return this.http.get(this.ADDRESS_API);
  }

  deletePlace(id: number): Observable<any> {
    return this.http.delete(this.PLACE_API + '/id/' + id);
  }

  createPlace(place: Place): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    };

    return this.http.post<Place>(this.PLACE_API, place, httpOptions);
  }

  changePlace(place: Place): Observable<any> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
      })
    };

    return this.http.put(this.PLACE_API, place, httpOptions);
  }

}
