import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-admin-useri',
  templateUrl: './admin-useri.component.html',
  styleUrls: ['./admin-useri.component.css']
})
export class AdminUseriComponent implements OnInit {

  users: any;

  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.getAllUsers();
  }

  getAllUsers() {
//    this.users = [{ username: 'Neko', name: 'Nekic' }, { username: 'Neko', name: 'Nekic' },{ username: 'Neko', name: 'Nekic' }, { username: 'Neko', name: 'Nekic' }];
    this.userService.getAllUsers().subscribe(data => {
      this.users = data;
      console.log(data)
    });
  }

  openUserDetails(user) {
    this.router.navigate(['/user-detalji', user.id]);
  }

  deleteUser(user) {
    this.userService.deleteUserById(user.id).subscribe(data => console.log(data));
  }

}