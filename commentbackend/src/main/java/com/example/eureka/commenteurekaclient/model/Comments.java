package com.example.eureka.commenteurekaclient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comments")
public class Comments {
	
	@Id
	int cid;
	
	
	@Column
	String commenter;
	
	@Column
	int pid;
	
	@Column
	String comment;
	
	public Comments() {
		
	}

	public Comments(int cid, String commenter, int pid, String comment) {
		super();
		this.cid = cid;
		this.commenter = commenter;
		this.pid = pid;
		this.comment = comment;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
