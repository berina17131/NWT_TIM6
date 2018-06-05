import { Component, OnInit } from '@angular/core';
import {EventService} from '../services/event/event.service';
import {Router} from '@angular/router';
import {AppComponent} from '../app.component';

@Component({
  selector: 'app-nauka',
  templateUrl: './nauka.component.html',
  styleUrls: ['./nauka.component.css']
})
export class NaukaComponent implements OnInit {

  events: Array<any>;
  event: any;
  selectedEvent: any;

  isAdmin: any;

  constructor(private eventService: EventService, private router: Router, private appComponent: AppComponent) { }

  ngOnInit() {
    this.isAdmin = this.appComponent.isAdmin;
    this.eventService.getEventsByCategory("Nauka").subscribe(data => {
      this.events = data;
      console.log(this.events.length);
    });
  }

  prikaziDetalje(event: any){
    
    this.router.navigate(['/nauka-detalji', event.id]);
  }

  obrisi(event: any){
    
    this.eventService.deleteEvent(event.id).subscribe(data => {
      console.log('successful');
      window.location.reload();
    });
  }
}
