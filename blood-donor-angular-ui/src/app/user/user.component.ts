import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';
import { User } from './user.info';

import { DataService } from '../data.service';
import { Search } from './user.search';
import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';
import { Feedback } from './user.feedback';
import { FeedbackService } from '../feedback.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users : User[];
  userInfo : User;
  donor : User;
  search : Search;
  feedBack : Feedback;
  public isCollapsed = true;
  feedbackMessage: string;
  constructor(
       private userService : UserService,
       private dataService : DataService,
       private modalService: NgbModal,
       private feedbackService: FeedbackService,
       private router : Router) { }
    
  ngOnInit() {
    this.dataService.currentUser.subscribe(user => this.userInfo = user);
    this.search = new Search();

    }

    open(content) {
      this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
          this.feedBack  = new Feedback();
          this.feedBack.feedbackMessage = this.feedbackMessage;
          this.feedBack.donor = result.user;
          this.feedBack.postedUser = result.userInfo;
          this.feedbackService.postFeedback(this.feedBack);
          this.getUsers();

      }, (reason) => {
         `Dismissed ${this.getDismissReason(reason)}`;
      });
    }
  
    private getDismissReason(reason: any): string {
      if (reason === ModalDismissReasons.ESC) {
        return 'by pressing ESC';
      } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
        return 'by clicking on a backdrop';
      } else {
        return  `with: ${reason}`;
      }
    }

    getUsers() : void
    {
      this.userService.getUsers().subscribe(users=> this.users = users);
    }

  searchByCity(search : Search) : void
  {
    this.userService.searchUsersByCity(search).subscribe(users=> this.users = users);
  }
 editUser(user : User):void
 {
  
  this.dataService.saveUser(user);
  this.router.navigate(["/edituser"]);
 }

 logout():void
 {
    this.router.navigate(["/login"]);
 }
  
 delete(loginId : string): void
 {
   console.log("*******loginID"+loginId);
    this.userService.deleteUserById(loginId).subscribe(() => console.log("user deleted"));
    this.users = this.users.filter(user => user.loginId != loginId);
 }
}
