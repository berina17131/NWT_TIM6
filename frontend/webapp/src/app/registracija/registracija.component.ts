import { Component, OnInit } from '@angular/core';
import { User } from '../services/user/User';
import { UserService } from '../services/user/user.service';
import { Router } from '@angular/router';
import { AuthService } from '../core/auth.service';
import { TokenStorage } from '../core/token.storage';
import { AppComponent } from '../app.component';

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

  constructor(private router: Router,
    private authService: AuthService,
    private tokenService: TokenStorage,
    private appComponent: AppComponent,
    private userService: UserService) { }

  ngOnInit() {
  }

  registrujSe(): void {
    this.authService.attemptAuth(this.username, this.password)
      .subscribe(
        data => {
          TokenStorage.saveToken(data.token);
          TokenStorage.saveCurrentUser(this.username);
          this.appComponent.goToHomePage();
          this.appComponent.isLoggedIn = true;
          this.appComponent.isAdmin = this.authService.isAdmin();
        },
        error => {
          console.error('Login failed...' + error);
        //  this.alert.open('Login failed. Wrong username or password!', null, { duration: 3000 });
        },
        () => {
          console.log('User: ' + this.username + ' successfuly logged in...');
          //this.alert.open('Login successful', null, { duration: 3000 });
        }
      );
  }

}
