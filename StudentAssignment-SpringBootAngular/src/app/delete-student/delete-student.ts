import { Component } from '@angular/core';
import { Student } from '../service/student';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-delete-student',
  imports: [FormsModule],
  templateUrl: './delete-student.html',
  styleUrl: './delete-student.css',
})
export class DeleteStudent {
    regNo : any
    constructor(private studentService:Student){

    } 
    ngOnInit(){
        this.regNo = this.studentService.sharedObj
        this.regNo = this.regNo.regNo

    }
    deleteStudent(stu:any){
      console.log(stu.form.value.id)
      this.studentService.deleteStudent(stu.form.value.id);
      stu.form.reset();
    }
}
