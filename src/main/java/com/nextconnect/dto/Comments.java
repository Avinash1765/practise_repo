package com.nextconnect.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nextconnect.constants.StatusEnum;

@Entity(name = "post_comments")
public class Comments {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comment_id_seq")
	@SequenceGenerator(allocationSize = 5, name = "comment_id_seq", sequenceName = "comment_seq")
	@Column(name = "comment_id")
	private Integer commentId;

	@ManyToOne(targetEntity = Post.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "post_id")
	private Post post;

	@Column(name = "COMMENT_CONTENT")
	private String commentText;

	@JsonIgnore
	@Column(name = "STATUS")
	private StatusEnum commentStatus;

	@JoinColumn(name = "comment_by")
	@ManyToOne(targetEntity = UserDetails.class, fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private UserDetails commentedUser;

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	
	public Integer getPostId() {
		return post.getPostId();
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public StatusEnum getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(StatusEnum commentStatus) {
		this.commentStatus = commentStatus;
	}

	@Override
	public String toString() {
		return "Comments [commentId=" + commentId + ", post=" + post + ", commentText=" + commentText
				+ ", commentStatus=" + commentStatus + ", commentedUser=" + commentedUser + "]" + post;
	}

	public UserDetails getCommentedUser() {
		return commentedUser;
	}


	public void setCommentedUser(UserDetails commentedUser) {
		this.commentedUser = commentedUser;
	}

}
