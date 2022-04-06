package com.example.postservice.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.postservice.model.Posts;

@Repository
@Transactional
public interface PostsDao extends JpaRepository<Posts,Integer>{
	
	@Query("select p from Posts p where p.author=?1")
	public List<Posts> searchPostsByAuthor(String author);
	
	@Query("select p from Posts p where p.title=?1")
	public List<Posts> searchPostsByTitle(String title);
	
	@Query("select p.author from Posts p where p.title=?1")
	public List<String> seachAuthorsByTitle(String title);
	
}
