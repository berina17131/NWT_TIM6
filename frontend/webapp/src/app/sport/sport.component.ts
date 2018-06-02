import { Component, OnInit } from '@angular/core';
import {EventService} from '../services/event/event.service';
import {Router} from '@angular/router';
import {AppComponent} from '../app.component';

@Component({
  selector: 'app-sport',
  templateUrl: './sport.component.html',
  styleUrls: ['./sport.component.css']
})
export class SportComponent implements OnInit {

  events: Array<any>;
  event: any;
  selectedEvent: any;

  isAdmin: any;

  constructor(private eventService: EventService, private router: Router, private appComponent: AppComponent) { }

  ngOnInit() {
    this.isAdmin = this.appComponent.isAdmin;
    this.eventService.getEventsByCategory("Sport").subscribe(data => {
      this.events = data;
      console.log(this.events.length);
    });
  }

  prikaziDetalje(event: any){
    this.selectedEvent = event;
    this.router.navigate(['/sport-detalji', this.selectedEvent.id]);
  }

  obrisi(event: any){

    this.eventService.deleteEvent(event.id).subscribe(data => {
      console.log('successful');
    });
  }

}
