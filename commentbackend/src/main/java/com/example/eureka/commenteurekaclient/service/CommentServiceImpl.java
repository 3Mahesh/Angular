package com.example.eureka.commenteurekaclient.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.eureka.commenteurekaclient.dao.CommentsDao;
import com.example.eureka.commenteurekaclient.model.Comments;
import com.example.eureka.commenteurekaclient.model.Posts;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentsDao commentsDao;
	
	@Autowired
	RestTemplate restTemplate;

	@Override
	public List<Comments> getAll() {
		// TODO Auto-generated method stub
		return commentsDao.findAll();
	}

	@Override
	public Comments addComment(Comments comment) {
		// TODO Auto-generated method stub
		return commentsDao.save(comment);
	}

	@Override
	public String deleteComment(int cid) {
		// TODO Auto-generated method stub
		commentsDao.deleteById(cid);
		return "Comment Deleted";
	}

	@Override
	public Comments updateComment(Comments comment) {
		// TODO Auto-generated method stub
		return commentsDao.save(comment);
	}

	@Override
	public List<Comments> getCommentsByPostId(int pid) {
		// TODO Auto-generated method stub
		List<Comments> data = commentsDao.findAll();
		List<Comments> result = new ArrayList();
		for (Comments comment : data) {
			if (comment.getPid() == pid)
				result.add(comment);
		}
		return result;

	}

	@Override
	public Posts getPostByPostId(int pid) {
		// TODO Auto-generated method stub
		
		Posts data = restTemplate.getForObject("http://POSTSERVICE/posts/id/"+pid, Posts.class);
		return data;
	}

	@Override
	public String deleteComments(Comments comment) {
		// TODO Auto-generated method stub
		commentsDao.delete(comment);
		return "Comment is deleted";
	}

}
