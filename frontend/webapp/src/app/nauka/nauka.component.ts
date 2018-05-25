import { Component, OnInit } from '@angular/core';
import {EventService} from '../services/event/event.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-nauka',
  templateUrl: './nauka.component.html',
  styleUrls: ['./nauka.component.css']
})
export class NaukaComponent implements OnInit {

  events: Array<any>;
  event: any;
  selectedEvent: any;

  constructor(private eventService: EventService, private router: Router) { }

  ngOnInit() {

    this.eventService.getEventsByCategory("nauka").subscribe(data => {
      this.events = data;
      console.log(this.events.length);
    });
  }

  obrisi(event: any){
    
    this.eventService.deleteEvent(event.id).subscribe(data => {
      console.log('successful');
    });
  }
}
