import { Component, OnInit } from '@angular/core';
import {  Address } from '../user/user.address'

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  loginId: string;
  firstName: string;
  lastName: string;
  emailId: string;
  phoneNo: number;
  address: Address;

  constructor() { }

  ngOnInit() {
  }

}
