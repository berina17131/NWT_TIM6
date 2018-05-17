import { Component, OnInit } from '@angular/core';
import { PlaceService } from '../services/place/place.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Http, Headers, Response, RequestOptions } from '@angular/http';

@Component({
  selector: 'app-admin-lokacija',
  templateUrl: './admin-lokacija.component.html',
  styleUrls: ['./admin-lokacija.component.css']
})
export class AdminLokacijaComponent implements OnInit {

  places: any;
  constructor(private placeService: PlaceService, private http: HttpClient) { }

  ngOnInit() {
    this.getAllPlaces();
  }

  getAllPlaces() {
    this.placeService.getAllPlaces().subscribe(data => {
      this.places = data;
    });
  }

}
