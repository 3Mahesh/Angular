import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Comments } from './Comments';

@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor(private httpClient : HttpClient) { }

  getAllComments(){
       return this.httpClient.get("http://localhost:8082/comments/all");
  }

  registerComment(cmts: any){
    this.httpClient.post("http://localhost:8082/comments/add/",cmts)
    .subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.log(error);
      });
  }

  searchCommentByPid(pid:any){
    return this.httpClient.get("http://localhost:8082/comments/pid/"+pid);
  }

  deleteCommentByCid(cmts: Comments) {
    return this.httpClient.delete("http://localhost:8082/comments/delete",{body:cmts});
  }
 
}