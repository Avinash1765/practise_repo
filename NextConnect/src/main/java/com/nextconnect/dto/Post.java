package com.nextconnect.dto;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nextconnect.constants.StatusEnum;

@Entity(name="posts")
public class Post {
	
	@Id
	@Column(name="post_id")
	@SequenceGenerator(allocationSize = 5, name = "post_seq_identifier",sequenceName = "post_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "post_seq_identifier")
	private Integer postId;
	
	@JoinColumn(name = "posted_by")
	@ManyToOne(targetEntity = UserDetails.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private UserDetails postedBy;
	
	@Column(name = "post_content")
	private String postContent;
	
	@Column(name="num_likes")
	private Integer numLikes= 0;
	
	@Column(name="CREATION_DATE")
	private Timestamp postCreationDate;
	
	@JsonIgnore
	@Column(name="status")
	private StatusEnum postStatus;
	
	@OneToMany(mappedBy = "post")
	private List<Comments> postComments= new ArrayList<>();
	
	@OneToMany(mappedBy = "likeDetail.post")
	private List<LikeDetails> likeDetails= new ArrayList<>();

	public List<LikeDetails> getLikeDetails() {
		return likeDetails;
	}
	public void setLikeDetails(List<LikeDetails> likeDetails) {
		this.likeDetails = likeDetails;
	}
	public Timestamp getPostCreationDate() {
		return postCreationDate;
	}
	public List<Comments> getPostComments() {
		return postComments;
	}
	public void setPostComments(List<Comments> postComments) {
		this.postComments = postComments;
	}
	public Integer getPostId() {
		return postId;
	}
	public void setPostId(Integer postId) {
		this.postId = postId;
	}
		
	//@JsonIgnore
	public UserDetails getPostedBy() {
		return postedBy;
	}
	
	public void setPostedBy(UserDetails postedBy) {
		this.postedBy = postedBy;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public Integer getNumLikes() {
		return numLikes;
	}
	public void setNumLikes(Integer numLikes) {
		this.numLikes = numLikes;
	}
	
	public long getPostCreationMillis() {
		return postCreationDate.getTime();
	}

	public void setPostCreationDate(Timestamp postCreationDate) {
		this.postCreationDate = postCreationDate;
	}
	public StatusEnum getPostStatus() {
		return postStatus;
	}
	public void setPostStatus(StatusEnum postStatus) {
		this.postStatus = postStatus;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postContent=" + postContent + ", numLikes="
				+ numLikes + ", postCreationDate=" + postCreationDate + ", postStatus=" + postStatus + "]"+ postedBy;
	}

}
