import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Student } from '../service/student';

@Component({
  selector: 'app-insert',
  standalone: false,
  templateUrl: './insert.html',
  styleUrl: './insert.css',
})
export class Insert {
  constructor(private router:Router,private s:Student){}
  createStudent(event:any){
      event.preventDefault();
      let regNo = event.target[0].value
      let rollNo = event.target[1].value
      let name = event.target[2].value 
      let standard= event.target[3].value 
      let school = event.target[4].value
      let student = {
         "regNo":regNo,
         "rollNo":rollNo,
         "name":name,
         "standard":standard,
         "school":school
      }
      this.s.addStudent(student);
  }

}
