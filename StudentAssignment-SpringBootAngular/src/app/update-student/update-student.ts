import { Component } from '@angular/core';
import { Student } from '../service/student';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-student',
  imports: [FormsModule],
  templateUrl: './update-student.html',
  styleUrl: './update-student.css',
})
export class UpdateStudent {
  student:any = {}
  constructor(private router: Router,public studentService:Student){}
    ngOnInit() {
      this.student = this.studentService.sharedObj
    }
  updateStudent(stu:any){
      this.studentService.updateStudent(stu.form.value);
      stu.form.reset();
  }
}
