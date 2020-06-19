package com.nextconnect.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nextconnect.dto.Following;
import com.nextconnect.dto.UserDetails;

public interface FollowingRepo extends CrudRepository<Following, Integer>{
	public List<Following> findByUser(UserDetails user);
	
	public List<Following> findByUserAndFollowingUserId(UserDetails currentUser, UserDetails followingUser);
}
