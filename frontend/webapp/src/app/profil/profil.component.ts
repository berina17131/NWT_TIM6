import { Component, OnInit } from '@angular/core';
import { User } from '../services/user/User';
import { UserService } from '../services/user/user.service';
import { Router } from '@angular/router';
import { AuthService } from '../core/auth.service';
import { TokenStorage } from '../core/token.storage';
import { AppComponent } from '../app.component';



@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  user: User = {
    id: '',
    username: '',
    password: '',
    email: '',
    ime: '',
    prezime: '',
    role: {
        id: 2,
    }
  };

  loggedUser: any;
    
  constructor(private router: Router,
    private authService: AuthService,
    private tokenService: TokenStorage,
    private appComponent: AppComponent,
    private userService: UserService) { }

  ngOnInit() {
    this.loggedUser = TokenStorage.getCurrentUser();

    this.userService.getByUsername(this.loggedUser).subscribe(data => {
      this.user = data;
       });

  }

  urediProfil() {
    this.userService.updateUser(this.user).subscribe(data => console.log(data));
    console.log(this.user);
  }

}
