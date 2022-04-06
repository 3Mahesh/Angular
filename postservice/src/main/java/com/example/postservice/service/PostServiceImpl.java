package com.example.postservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.postservice.model.CommentsDto;
import com.example.postservice.model.Posts;
import com.example.postservice.repo.PostsDao;


@Service
public class PostServiceImpl implements PostService{
	
	@Autowired
	RestTemplate template;
	
	@Autowired
	PostsDao dao;

	@Override
	public List<Posts> getAllPosts() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Posts insertPost(Posts post) {
		// TODO Auto-generated method stub
		return dao.save(post);
	}

	@Override
	public String deletePost(Posts post) {
		// TODO Auto-generated method stub
		dao.delete(post);
		return "Post Deleted...";
	}

	@Override
	public Optional<Posts> findByPostId(int pid) {
		// TODO Auto-generated method stub
		return dao.findById(pid);
	}

	@Override
	public List<Posts> searchPostsByAuthor(String author) {
			
		return dao.searchPostsByAuthor(author);
	}

	@Override
	public List<Posts> searchPostsByTitle(String title) {
		// TODO Auto-generated method stub
		
		return dao.searchPostsByTitle(title);
	}

	@Override
	public List<String> seachAuthorsByTitle(String title) {
		// TODO Auto-generated method stub
		return dao.seachAuthorsByTitle(title);
	}

	@Override
	public List<CommentsDto> searchCommentsByPid(int pid) {
		return template.getForObject("http://localhost:8082/comments/search/post/"+pid, List.class);
	
	}
	
	

}
