package com.example.postservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.postservice.model.CommentsDto;
import com.example.postservice.model.Posts;
import com.example.postservice.service.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	PostService service;
	
	
	@GetMapping("/all")
	public ResponseEntity<List<Posts>> showAllPosts(){
		return new ResponseEntity(service.getAllPosts(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Posts> addPost(@RequestBody Posts post){
		return new ResponseEntity(service.insertPost(post), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletePost(@RequestBody Posts post){
		return new ResponseEntity(service.deletePost(post), HttpStatus.OK);
	}

	@GetMapping("/search/author/{author}")
	public ResponseEntity<List<Posts>> getAllPostsByAuthor(@PathVariable("author")  String author){
		return new ResponseEntity(service.searchPostsByAuthor(author), HttpStatus.OK);
	}

	@GetMapping("/search/title/{title}")
	public ResponseEntity<List<Posts>> getAllPostsByTitle(@PathVariable("title") String title){
		return new ResponseEntity(service.searchPostsByTitle(title), HttpStatus.OK);
	}
	
	@GetMapping("/search/author/title/{title}")
	public ResponseEntity<List<String>> getAllAuthorsByTitle(@PathVariable("title") String title){
		
		return new ResponseEntity(service.seachAuthorsByTitle(title), HttpStatus.OK);
	}
	
	
	@GetMapping("/search/comments/pid/{pid}")
	public ResponseEntity<List<CommentsDto>> getAllCommentsByPid(@PathVariable("pid") int pid){
		
		return new ResponseEntity(service.searchCommentsByPid(pid), HttpStatus.OK);
	}
}
