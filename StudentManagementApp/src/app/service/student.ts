import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Student {
  student:any[]  = [
  {
    regNo: "REG101",
    rollNo:"1",
    name: "Amit Sharma",
    standard: "10",
    school: "St. Xavier High School"
  },
  {
    regNo: "REG102",
    rollNo: 2,
    name: "Priya Mehta",
    standard: "9",
    school: "Delhi Public School"
  },
  {
    regNo: "REG103",
    rollNo: 3,
    name: "Rahul Verma",
    standard: "10",
    school: "St. Mary's School"
  },
  {
    regNo: "REG104",
    rollNo: 4,
    name: "Sneha Patil",
    standard: "8",
    school: "Podar International School"
  },
  {
    regNo: "REG105",
    rollNo: 5,
    name: "Arjun Nair",
    standard: "9",
    school: "DAV Public School"
  },
  {
    regNo: "REG106",
    rollNo: 6,
    name: "Neha Gupta",
    standard: "10",
    school: "Ryan International School"
  },
  {
    regNo: "REG107",
    rollNo: 7,
    name: "Karan Singh",
    standard: "8",
    school: "St. Joseph School"
  }
];
  addStudent(s:any){
    this.student.push(s)
  }
  removeStudent(id:any){
      this.student = this.student.filter(s=>s.rollNo != id)
  }
  updateStudent(stu:any){
    this.student = this.student.filter(s=>s.rollNo != stu.rollNo)
    this.student.push(stu)
  }
  viewStudent():any[]{
    return this.student;
  }
  viewByRollno(rollNo:any){
    return this.student.filter(s=>s.rollNo === rollNo)
  }
}
