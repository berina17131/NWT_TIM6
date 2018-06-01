import { Component, OnInit } from '@angular/core';
import {EventService} from '../services/event/event.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-kultura',
  templateUrl: './kultura.component.html',
  styleUrls: ['./kultura.component.css']
})
export class KulturaComponent implements OnInit {

  events: Array<any>;
  event: any;
  selectedEvent: any;

  constructor(private eventService: EventService, private router: Router) { }

  ngOnInit() {

    this.eventService.getEventsByCategory("Kultura").subscribe(data => {
      this.events = data;
      console.log(this.events.length);
    });
  }

  prikaziDetalje(event: any){
    this.selectedEvent = event;
    this.router.navigate(['/kultura-detalji', this.selectedEvent.id]);
  }

  obrisi(event: any){

    this.eventService.deleteEvent(event.id).subscribe(data => {
      console.log('successful');
    });
  }
  
}
