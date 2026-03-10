import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { Login } from './login/login';
import { Admin } from './admin/admin';
import { View } from './view/view';
import { Insert } from './insert/insert';
import { Update } from './update/update';
import { Delete } from './delete/delete';
import { Staff } from './staff/staff';
import { Menu } from './menu/menu';
import { Logout } from './logout/logout';

@NgModule({
  declarations: [App, Login, Admin, View, Insert, Update, Delete, Staff, Menu, Logout],
  imports: [BrowserModule, AppRoutingModule],
  providers: [provideBrowserGlobalErrorListeners()],
  bootstrap: [App],
})
export class AppModule {}
