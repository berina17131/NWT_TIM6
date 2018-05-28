import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: any;
  password: any;

  constructor(private userService: UserService) { }

  ngOnInit() {
  }

  prijaviSe(){
  // this.userService.getToken
  }
}
