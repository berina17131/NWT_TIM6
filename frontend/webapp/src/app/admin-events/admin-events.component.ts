import { Component, OnInit } from '@angular/core';
import {EventService} from '../services/event/event.service';
import {Router} from '@angular/router';
import {Event} from '../services/event/Event';

@Component({
  selector: 'app-admin-events',
  templateUrl: './admin-events.component.html',
  styleUrls: ['./admin-events.component.css']
})
export class AdminEventsComponent implements OnInit {

  events: Array<any>;
  event: any;
  selectedEvent: any;

  newEvent: Event = {
    name: '',
    description: '',
    category: {
      id: null
    },
    place:{
      id: null
    }
  };

  modal_naziv: any;
  modal_opis: any;
  modal_kategorija: any;

  constructor(private eventService: EventService, private router: Router) { }

  ngOnInit() {

    this.eventService.getEventsByCategory("muzika").subscribe(data => {
      this.events = data;
      console.log(this.events.length);
    });
  }

  obrisi(event: any){

    this.eventService.deleteEvent(event.id).subscribe(data => {
      console.log('successful');
    });
  }

  prikaziDetalje(event) {
    this.modal_naziv = event.name;
    this.modal_opis = event.description;
    this.modal_kategorija ="a";
    //this.modal_adresa = place.address;
  }

  loadajStranicu() {
    window.location.reload();
  }

  kreirajEvent(){
    this.newEvent.name = this.modal_naziv;
    this.newEvent.description = this.modal_opis;
    this.newEvent.category.id = 1;
    this.newEvent.place.id = 1;
    

    this.eventService.createEvent(this.newEvent).subscribe(data => {
      console.log(data);
    });
  }

  sacuvajIzmjeneEvent(){
    
      this.newEvent.name = this.modal_naziv;
      this.newEvent.description = this.modal_opis;
      this.newEvent.category.id = 1;
      this.newEvent.place.id = 1;

      this.eventService.changeEvent(this.newEvent).subscribe((data) => {
      console.log(data);
      this.loadajStranicu();
    });
  }


}
