import { Component, OnInit } from '@angular/core';
import {EventService} from '../services/event/event.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-zabava',
  templateUrl: './zabava.component.html',
  styleUrls: ['./zabava.component.css']
})
export class ZabavaComponent implements OnInit {

  events: Array<any>;
  event: any;
  selectedEvent: any;

  constructor(private eventService: EventService, private router: Router) { }

  ngOnInit() {

    this.eventService.getEventsByCategory("Zabava").subscribe(data => {
      this.events = data;
      console.log(this.events.length);
    });
  }

  prikaziDetalje(event: any){
    this.selectedEvent = event;
    console.log(this.selectedEvent.id);
    this.router.navigate(['/zabava-detalji', this.selectedEvent.id]);
  }

  obrisi(event: any){

    this.eventService.deleteEvent(event.id).subscribe(data => {
      console.log('successful');
    });
  }

}
