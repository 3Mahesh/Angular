import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommentService } from '../comment.service';
import { Comments } from '../Comments';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  show: boolean = true;
  cid=0;
  pid=0;
  commenter="";
  comment="";
  formdata: FormGroup = new FormGroup({
    cid: new FormControl("cid",[Validators.required, Validators.minLength(4)]),
    pid: new FormControl("Pid",[Validators.required, Validators.minLength(4)]),
    commenter: new FormControl("Commenter Name", Validators.required),
    comment: new FormControl("Comment", Validators.required) 
  });
  constructor(private service: CommentService, private router: Router) { }

  ngOnInit(): void {
  }

  insertComment(){

    let cmt : Comments = {
      "cid":this.cid,
      "commenter":this.commenter,
      "pid":this.pid,
      "comment":this.comment
       }
    //console.log(this.cid+" "+this.commenter+" "+this.pid+" "+this.comment);
      this.service.registerComment(cmt);
      this.router.navigateByUrl("display");

  }

}
