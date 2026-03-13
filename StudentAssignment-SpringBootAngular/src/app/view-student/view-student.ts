import { ChangeDetectorRef, Component } from '@angular/core';
import { Student } from '../service/student';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { StudentEntity } from '../Models/student.modelStudent';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-view-student',
  imports: [CommonModule,FormsModule],
  templateUrl: './view-student.html',
  styleUrl: './view-student.css',
})
export class ViewStudent {
  students!: Observable<StudentEntity[]>
  stu!: Observable<StudentEntity>
  studentSearch!:Observable<StudentEntity[]>
  currentSection : string = 'full-view'
  selectedOption!:string
  setCurrentSection(str : string ){  
    this.currentSection = str
  }
  fetchRecords(id:string){
    console.log(this.selectedOption)
    if(this.currentSection == 'regNo-view'){this.stu = this.studentService.getStudentById(id);
    this.stu.subscribe((res:any)=>{
      console.log(res)
    })}
    if(this.currentSection == 'school-view'){this.studentSearch = this.studentService.getStudentBySchool(id);
    this.studentSearch.subscribe((res)=>{
      console.log(res)
    })
  }
    if(this.currentSection == 'res-view'){this.studentSearch = this.studentService.getStudentByRes(id)
      this.studentSearch.subscribe((res)=>{
          console.log(res)
      })
    }
    console.log(this.currentSection)

  }
  navigateUpdate(student:any){
    this.studentService.setSharedObj(student)
    this.router.navigate(["update"])
  }
  navigateDelete(student:any){
    this.studentService.setSharedObj(student)
    this.router.navigate(["delete"])
  }
  constructor(private router:Router,public studentService : Student,private cd: ChangeDetectorRef){
      this.students = studentService.getStudents()
  }

}
