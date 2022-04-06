package com.example.postservice.service;

import java.util.List;
import java.util.Optional;

import com.example.postservice.model.CommentsDto;
import com.example.postservice.model.Posts;

public interface PostService {
	
	public List<Posts> getAllPosts();
	public Posts insertPost(Posts post);
	public String deletePost(Posts post);
	public Optional<Posts> findByPostId(int pid);
	public List<Posts> searchPostsByAuthor(String author);
	public List<Posts> searchPostsByTitle(String title);
	public List<String> seachAuthorsByTitle(String title);
	
	public List<CommentsDto> searchCommentsByPid(int pid);

}
