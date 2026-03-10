import { Component } from '@angular/core';
import { User } from '../service/user';

@Component({
  selector: 'app-menu',
  standalone: false,
  templateUrl: './menu.html',
  styleUrl: './menu.css',
})
export class Menu {
    constructor(public user:User){}
    logout(){
      this.user.setName("Guest");
      this.user.setRole("");

    }
}
