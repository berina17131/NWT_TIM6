import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {EventService} from './services/event/event.service';
import {AuthService} from './core/auth.service';
import { TokenStorage } from './core/token.storage';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent{
  title = 'app';

  events: Array<any>;
  modal_naziv: any;

  findByEvent: any;
  findByPlace: any;
  odabranaOpcijaPretrage: any;
  opcijePretrage = [{id: 1, name: 'Pretraga po nazivu događaja'}, {id: 2, name: 'Pretraga po nazivu lokala'}];

  isLoggedIn: boolean;
  isAdmin: boolean;

  loggedUser: any;


  constructor(private router: Router, private eventService: EventService, private authService: AuthService) {}

  
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
  }
  
  goToHomePage() {
    this.router.navigate(['/muzika']);
  }

  ngOnInit() {
    this.isLoggedIn = this.authService.isLoggedIn();
    this.isAdmin = this.authService.isAdmin();
    this.loggedUser = TokenStorage.getCurrentUser();
  }

  odjaviSe() {
    TokenStorage.logOut();
    this.isLoggedIn = false;
    this.isAdmin = false;
    this.router.navigate(['/login']);
  }

}
