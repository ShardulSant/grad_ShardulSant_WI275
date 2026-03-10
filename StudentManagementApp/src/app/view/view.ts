import { Component } from '@angular/core';
import { Student } from '../service/student';
import { User } from '../service/user';

@Component({
  selector: 'app-view',
  standalone: false,
  templateUrl: './view.html',
  styleUrl: './view.css',
})
export class View {
  constructor( public s:Student,public user:User){}
  deleteStudent(id:any){
    this.s.removeStudent(id);
  }
}
