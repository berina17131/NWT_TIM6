import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user/user.service';

@Component({
  selector: 'app-user-detalji',
  templateUrl: './user-detalji.component.html',
  styleUrls: ['./user-detalji.component.css']
})
export class UserDetaljiComponent implements OnInit {

  userr: any;
  id: number;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getUserById();
  }

  getUserById() {
    this.userService.getUserById(this.id).subscribe(data => {
      this.userr = data;
    });
  }

}
