import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class User {
  name:string = "Guest"
  role:string = ""
  setName(n:string){
    this.name = n
  }
  getName():string{
    return this.name
  }
  setRole(userRole:string){
    this.role = userRole;
  }
  getRole():string{
    return this.role
  }
}
