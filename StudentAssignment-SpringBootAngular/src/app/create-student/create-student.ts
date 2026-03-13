import { Component } from '@angular/core';
import { Student } from '../service/student';
import { FormsModule, NgModel } from '@angular/forms';

@Component({
  selector: 'app-create-student',
  imports: [FormsModule],
  templateUrl: './create-student.html',
  styleUrl: './create-student.css',
})
export class CreateStudent {
    constructor(private studentService:Student){}
    addStudent(stu:any){
      console.log(stu)

        this.studentService.addStudent(stu.form.value);
        stu.form.reset();
    }
}
