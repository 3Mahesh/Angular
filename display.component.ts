import { Component, OnInit } from '@angular/core';
import { CommentService } from '../comment.service';

@Component({
  selector: 'app-display',
  templateUrl: './display.component.html',
  styleUrls: ['./display.component.css']
})
export class DisplayComponent implements OnInit {

  constructor(private service: CommentService) { }
  cmts:any;
  ngOnInit(): void {
    this.service.getAllComments()
    .subscribe( (response: any) =>{
      this.cmts=response;
      console.log(response);
    }
    );
    console.log(this.cmts);
  }


  
}