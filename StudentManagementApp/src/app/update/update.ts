import { Component } from '@angular/core';
import { Student } from '../service/student';

@Component({
  selector: 'app-update',
  standalone: false,
  templateUrl: './update.html',
  styleUrl: './update.css',
})
export class Update {
  constructor(public student:Student){}
  updateStudent(event:any){
      event.preventDefault();
      let regNo = event.target[1].value
      let rollNo = event.target[0].value
      let name = event.target[2].value 
      let standard= event.target[3].value 
      let school = event.target[4].value
      let stu = {
         "regNo":regNo,
         "rollNo":rollNo,
         "name":name,
         "standard":standard,
         "school":school
      }
      console.log(stu)
      this.student.updateStudent(stu);

  }

}
