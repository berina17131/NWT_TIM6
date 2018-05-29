import { Component, OnInit } from '@angular/core';
import { User } from '../services/user/User';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent implements OnInit {

  user: User = {
    username: '',
    password: '',
    email: '',
    ime: '',
    prezime: '',
    role: {
        id: null,
    }
  };

  constructor() { }

  ngOnInit() {
  }

  registrujSe() {
    console.log(this.user);
  }

}
