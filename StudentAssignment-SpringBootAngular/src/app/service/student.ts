import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, ObservableLike } from 'rxjs';
import { StudentEntity } from '../Models/student.modelStudent';

@Injectable({
  providedIn: 'root',
})
export class Student {
    constructor(private ht:HttpClient){}
    students:any[] = [];
    sharedObj:any
    setSharedObj(stu:any){
        this.sharedObj= stu
    } 
    getStudents() : Observable<StudentEntity[]>{  
        return this.ht.get<StudentEntity[]>("http://localhost:8080/student")
    }
    addStudent(stu : any):void{
        this.ht.post("http://localhost:8080/student",stu,{responseType:'text'}).subscribe((res)=>{
            console.log(res);
        })
    }
    updateStudent(stu:any):void{
        this.ht.put("http://localhost:8080/student/"+stu.regNo,stu,{responseType:'text'}).subscribe((res)=>{
            console.log(res);
        })
    }
    deleteStudent(id : number):void{
        this.ht.delete("http://localhost:8080/student/"+id,{responseType:'text'}).subscribe((res)=>{
            console.log(res)
        })
    }
    getStudentById(id:string):Observable<StudentEntity>{
        return this.ht.get<StudentEntity>("http://localhost:8080/student/"+id)
    }
    getStudentBySchool(id:string):Observable<StudentEntity[]>{
        return this.ht.get<StudentEntity[]>("http://localhost:8080/student/school/"+id);
    }
    getStudentByRes(id:string):Observable<StudentEntity[]>{
        return this.ht.get<StudentEntity[]>("http://localhost:8080/student/result/"+id);
    }
}
