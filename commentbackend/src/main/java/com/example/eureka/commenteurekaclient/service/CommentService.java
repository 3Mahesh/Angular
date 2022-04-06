package com.example.eureka.commenteurekaclient.service;

import java.util.List;
import java.util.Optional;

import com.example.eureka.commenteurekaclient.model.Comments;
import com.example.eureka.commenteurekaclient.model.Posts;


public interface CommentService {
	public List<Comments> getAll();
	public Comments addComment(Comments comment);
	public String deleteComments(Comments comment);
	public String deleteComment(int cid);
	public Comments updateComment(Comments comment);
	public List<Comments> getCommentsByPostId(int pid);
	public Posts getPostByPostId(int pid);
}
