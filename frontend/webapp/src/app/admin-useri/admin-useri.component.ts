import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user/user.service';

@Component({
  selector: 'app-admin-useri',
  templateUrl: './admin-useri.component.html',
  styleUrls: ['./admin-useri.component.css']
})
export class AdminUseriComponent implements OnInit {

  users: any;

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.getAllUsers();
  }

  getAllUsers() {
    this.users = [{ username: 'Neko', name: 'Nekic' }, { username: 'Neko', name: 'Nekic' },{ username: 'Neko', name: 'Nekic' }, { username: 'Neko', name: 'Nekic' }];
    /*this.userService.getAllUsers().subscribe(data => {
      this.users = data;
    });*/
  }

  openUserDetails(user) {
    
  }


}
