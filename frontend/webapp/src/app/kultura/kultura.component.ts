import { Component, OnInit } from '@angular/core';
import { EventService } from '../services/event/event.service';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Http, Headers, Response, RequestOptions } from '@angular/http';

@Component({
  selector: 'app-kultura',
  templateUrl: './kultura.component.html',
  styleUrls: ['./kultura.component.css']
})
export class KulturaComponent implements OnInit {

  events: any;
  constructor(private eventService: EventService, private http: HttpClient) { }

  ngOnInit() {
    this.getAllEvents();
  }

  getAllEvents() {
    this.eventService.getAllEvents().subscribe(data => {
      this.events = data;
    });
  }
}
