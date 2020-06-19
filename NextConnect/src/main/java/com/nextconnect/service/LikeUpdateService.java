package com.nextconnect.service;

import java.util.Date;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nextconnect.dto.LikeDetailPk;
import com.nextconnect.dto.LikeDetails;
import com.nextconnect.dto.Post;
import com.nextconnect.dto.UserDetails;
import com.nextconnect.repos.LikeDetailRepo;
import com.nextconnect.repos.PostRepo;

@Service
public class LikeUpdateService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private LikeDetailRepo likeDetailRepo;

	public synchronized void updateLikes(Integer postId, Integer userId) {
		System.out.println("reached "+ new Date());
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(userId);

		Post post = new Post();
		post.setPostId(postId);
		
		LikeDetailPk likeDetailPk=new LikeDetailPk(userDetails, post);
		LikeDetails likeDetailsFromDB=null;
		try {
			likeDetailsFromDB=likeDetailRepo.findById(likeDetailPk).get();
		}catch(NoSuchElementException e) {
			LikeDetails likeDetailsObj= new LikeDetails();
			likeDetailsObj.setLikeDetail(likeDetailPk);
			likeDetailRepo.save(likeDetailsObj);
		}
		
		Post fullPostObj = postRepo.findById(postId).get();
		
		if(likeDetailsFromDB!=null) {
			likeDetailRepo.delete(likeDetailsFromDB);
			fullPostObj.setNumLikes(fullPostObj.getNumLikes() - 1);
		}else {
			fullPostObj.setNumLikes(fullPostObj.getNumLikes() + 1);
		}

		postRepo.save(fullPostObj);

	}
}
