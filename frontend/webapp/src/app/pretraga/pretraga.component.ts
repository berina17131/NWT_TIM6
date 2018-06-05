import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {EventService} from '../services/event/event.service';
import {AuthService} from '../core/auth.service';

@Component({
  selector: 'app-pretraga',
  templateUrl: './pretraga.component.html',
  styleUrls: ['./pretraga.component.css']
})
export class PretragaComponent implements OnInit {


  constructor(private router: Router, private eventService: EventService, private authService: AuthService) {}

  events: Array<any>;
  modal_naziv: any;

  findByEvent: any;
  findByPlace: any;
  odabranaOpcijaPretrage: any;
  opcijePretrage = [{id: 1, name: 'Pretraga po nazivu događaja'}, {id: 2, name: 'Pretraga po nazivu lokala'}];


  ngOnInit() {
  }

  pretraziEvente(){

    if(this.odabranaOpcijaPretrage == 1)
    {
      this.eventService.getByName(this.modal_naziv).subscribe(data => {
        this.events = data;
        console.log(this.events.length);
      });
    }
    if(this.odabranaOpcijaPretrage == 2)
    {
      this.eventService.getByNameOfPlace(this.modal_naziv).subscribe(data => {
        this.events = data;
        console.log(this.events.length);
      });
    }
    this.router.navigate(['/pretraga']);
  }

  obrisi(event: any){

    this.eventService.deleteEvent(event.id).subscribe(data => {
      console.log('successful');
      //window.location.reload();
    });
    window.location.reload();
  }


}
