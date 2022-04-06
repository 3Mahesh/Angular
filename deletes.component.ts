import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CommentService } from '../comment.service';
import { Comments } from '../Comments';

@Component({
  selector: 'app-deletes',
  templateUrl: './deletes.component.html',
  styleUrls: ['./deletes.component.css']
})
export class DeletesComponent implements OnInit {

  comt : Comments=new Comments()
  constructor(private service: CommentService, private router: Router) { }

  ngOnInit(): void {
  }

  formdata: FormGroup = new FormGroup({
    cid: new FormControl("", Validators.required),
    pid: new FormControl("", Validators.required),
    commenter: new FormControl("", Validators.required),
    comment: new FormControl("", Validators.required)
  });

  deleteCommentsByCid() {
    let res = this.service.deleteCommentByCid(this.comt);
    res.subscribe((data) => console.log(data))

    if(this.formdata.valid) {
    this.router.navigateByUrl("display");
    }
  }

}
