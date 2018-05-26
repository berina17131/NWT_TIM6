import { Component, OnInit } from '@angular/core';
import { PlaceService } from '../services/place/place.service';
import {Place} from '../services/place/Place';

@Component({
  selector: 'app-admin-lokacija',
  templateUrl: './admin-lokacija.component.html',
  styleUrls: ['./admin-lokacija.component.css']
})
export class AdminLokacijaComponent implements OnInit {

  places: any;

  objekat: Place = {
    name: '',
    description: '',
    address: {
      id: null
    }
  };

  objekat_name: any;
  objekat_description: any;

  modal_naziv: any;
  modal_opis: any;
  modal_adresa: any;

  constructor(private placeService: PlaceService) { }

  ngOnInit() {
    this.getAllPlaces();
  }

  getAllPlaces() {
    this.placeService.getAllPlaces().subscribe(data => {
      this.places = data;
    });
  }

  kreirajObjekat(){ //create place
    this.objekat.name = this.objekat_name;
    this.objekat.description = this.objekat_description;
    //pitanje sta uradit sa adresama?? 

    this.placeService.createPlace(this.objekat).subscribe(data => {
      console.log(data);
    });
  }

  prikaziDetalje(place) {
    this.modal_naziv = place.name;
    this.modal_opis = place.description;
    this.modal_adresa = place.address;
  }

  sacuvajIzmjenePlace(){

    
  }

}
