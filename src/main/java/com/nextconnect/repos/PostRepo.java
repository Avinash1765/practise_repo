package com.nextconnect.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nextconnect.dto.Post;
import com.nextconnect.dto.UserDetails;


public interface PostRepo extends CrudRepository<Post, Integer>{
	
	public List<Post> findByPostedByIn(List<UserDetails> postedBy);
}
