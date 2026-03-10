import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../service/user';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
    constructor(private router:Router,private user:User){}
    userLogin(event:any){
        event.preventDefault();
        let uname = event.target[0].value;
        let password = event.target[1].value;
        let role = event.target[2].value;
        console.log(uname + " "+password + " "+role);
        this.user.setName(uname)
        this.user.setRole(role)
        if(role == 'Admin' && uname == "abc" && password=="abc123" )this.router.navigate(["admin"])
        else if(role == 'Staff' && uname == "abc" && password=="abc")this.router.navigate(["view"])
    }


}
