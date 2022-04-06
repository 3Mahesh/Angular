package com.example.eureka.commenteurekaclient.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.eureka.commenteurekaclient.model.Comments;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface CommentsDao extends JpaRepository<Comments,Integer>{

}
