import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Route,RouterModule } from '@angular/router';
import {  UserComponent } from './user/user.component';
import { UserDetailsComponent } from './user-details/user-details.component'
import { LoginComponent } from './login/login.component'
export const routes : Route[] 
=
[
  {path : 'login',component : LoginComponent},
  {path : 'users',component : UserComponent},
  {path : 'users/:id',component : UserDetailsComponent},
  {path :'', redirectTo:'/login' , pathMatch : 'full'}
];
@NgModule({
 exports : [ RouterModule],

  imports: [
    RouterModule.forRoot(routes)
  ]
})
export class AppRoutingModule { }
