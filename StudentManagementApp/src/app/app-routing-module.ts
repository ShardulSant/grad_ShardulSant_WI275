import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Login } from './login/login';
import { Admin } from './admin/admin';
import { Insert } from './insert/insert';
import { View } from './view/view';
import { Update } from './update/update';
import { Delete } from './delete/delete';
import { userGuard } from './guards/user-guard';
import { Staff } from './staff/staff';
import { staffGuard } from './guards/staff-guard';
import { Logout } from './logout/logout';

const routes: Routes = [
  {
    path:"",
    redirectTo:"/login",
    pathMatch:"full"
  },
  {
    path:"login",
    component:Login
  },
  {
    path:"logout",
    component:Logout
  },
  {
    path:"create",
    component:Insert,
    canActivate:[userGuard]
  },
  {
    path:"update",
    component:Update,
    canActivate:[userGuard]
  },
  {
    path:"delete",
    component:Delete,
    canActivate:[userGuard]
  },
  {
    path:"view",
    component:View
  },
  {
    path:"admin",
    component:Admin,
    canActivate:[userGuard]
  },
  {
    path:"staff",
    component:Staff,
    canActivate:[staffGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
