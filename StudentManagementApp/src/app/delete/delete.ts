import { Component } from '@angular/core';
import { Student } from '../service/student';

@Component({
  selector: 'app-delete',
  standalone: false,
  templateUrl: './delete.html',
  styleUrl: './delete.css',
})
export class Delete {
    constructor(public student:Student){}
    deleteStudent(event:any){
      event.preventDefault();
      let rollNo = event.target[0].value;
      this.student.removeStudent(rollNo);

    }
}
