import { Component, OnInit } from '@angular/core';
import {EventService} from '../services/event/event.service';
import {Router} from '@angular/router';
import {AppComponent} from '../app.component';
import {Event} from '../services/event/Event';

@Component({
  selector: 'app-zabava',
  templateUrl: './zabava.component.html',
  styleUrls: ['./zabava.component.css']
})
export class ZabavaComponent implements OnInit {

  eventPut: Event = {
    id: null,
    name: '',
    description: '',
    category: {
      id: null
    },
    place: {
      id: null
    }
  };

  events: Array<any>;
  event: Event = {
    id: null,
    name: '',
    description: '',
    category: {
      id: null
    },
    place: {
      id: null
    }
  };

  selectedEvent: any;

  modal_naziv: any;
  modal_opis: any;
  modal_kategorija: any;

  isAdmin: any;

  constructor(private eventService: EventService, private router: Router, private appComponent: AppComponent) { }

  ngOnInit() {
    this.isAdmin = this.appComponent.isAdmin;
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

  prikaziDetaljeIzmjena(event) {
    this.eventPut = event;
    this.modal_naziv = event.name;
    this.modal_opis = event.description;
    this.modal_kategorija = event.category.name;
    //this.modal_adresa = place.address;
  }

  sacuvajIzmjeneEvent(){
    this.eventService.changeEvent(this.eventPut).subscribe(data => {
      console.log('successful');
      window.location.reload();
    });
  }

}
