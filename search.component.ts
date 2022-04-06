import { Component, OnInit } from '@angular/core';
import { CommentService } from '../comment.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  pid=0;
  cmts:any;

  constructor(private service:CommentService) { }

  ngOnInit(): void {

  }

  searchComments(){
    
      this.service.searchCommentByPid(this.pid)
      .subscribe( response =>{
        this.cmts=response;
        console.log(response);
      }
      );
      console.log(this.cmts);
    }
  }

