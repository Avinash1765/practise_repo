package com.nextconnect.controller;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nextconnect.constants.NextConnectConstants;
import com.nextconnect.constants.StatusEnum;
import com.nextconnect.dto.Comments;
import com.nextconnect.dto.Following;
import com.nextconnect.dto.Post;
import com.nextconnect.dto.UserDetails;
import com.nextconnect.dto.UserFeedDto;
import com.nextconnect.repos.CommentsRepo;
import com.nextconnect.repos.FollowingRepo;
import com.nextconnect.repos.PostRepo;
import com.nextconnect.repos.UserRepository;
import com.nextconnect.service.LikeUpdateService;

@RestController
@CrossOrigin(origins={"http://localhost:3000"})
public class NextConnectController {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private CommentsRepo commentRepo;

	@Autowired
	private FollowingRepo followingRepo;
	
	@Autowired
	private LikeUpdateService likeUpdateService;

	@RequestMapping(value = "/new-like/{POST_ID_FOR_LIKE}/{USER_ID}")
	public void updateLikeCount(@PathVariable(NextConnectConstants.POST_ID_FOR_LIKE) Integer postId,
			@PathVariable(NextConnectConstants.USER_ID) Integer userId) {
		
		likeUpdateService.updateLikes(postId, userId);
		
	}

	@RequestMapping(value = "/create-post", method = RequestMethod.POST)
	public Post storePost(@RequestBody Post post) {
		post.setPostCreationDate(new Timestamp(System.currentTimeMillis()));
		// post.setNumLikes(0);
		post.setPostStatus(StatusEnum.ACTIVE);

		Post postObjToReturn = postRepo.save(post);

		postObjToReturn.setPostedBy(userRepo.findById(postObjToReturn.getPostedBy().getUserId()).get());
		System.out.println(postObjToReturn);
		return postObjToReturn;
	}

	@RequestMapping(value = "/add-comment", method = RequestMethod.POST)
	public Comments addComment(@RequestBody Comments commentEntry) {
		commentEntry.setCommentStatus(StatusEnum.ACTIVE);
		System.out.println(commentEntry);
		return commentRepo.save(commentEntry);
	}

	@RequestMapping("/get-user-details")
	public UserFeedDto fetchUserFeed(@RequestParam(NextConnectConstants.USER_MAIL_PARAM) String userMailId) {
		UserFeedDto userFeed = new UserFeedDto();
		userFeed.setUserDetails(userRepo.findByEmailIdIgnoreCase(userMailId).get(0));

		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(userFeed.getUserDetails().getUserId());
		// FollowingPk followpk=new FollowingPk();
		// followpk.setUser(userDetails);
		
		List<Following> followingUserList=followingRepo.findByUser(userDetails);


		List<UserDetails> followingUsers=
				followingUserList.stream().map(obj -> obj.getFollowingUserId()).collect(Collectors.toList());
		

		followingUsers.add(userFeed.getUserDetails());

		List<Post> userFeedPosts = postRepo.findByPostedByIn(followingUsers);
		
		followingUsers.remove(followingUsers.size()-1);

		userFeed.setUserPosts(userFeedPosts);
		userFeed.setFollowingUsers(followingUsers);
		return userFeed;
	}

	@RequestMapping("/get-comment")
	public Comments getComment(@RequestParam("commentId") Integer commentId) {
		return commentRepo.findById(commentId).get();
	}
	
	@RequestMapping("/toggle-follower")
	public void toggleUserFollowing(@RequestParam("currentUserId") Integer currentUserId,
			@RequestParam("followingUserId") Integer followingUserId) {
		System.out.println(" current user "+ currentUserId);
		System.out.println("following user "+ followingUserId);
		Following followingObj= new Following();
		boolean isRealationShipPresent= true;
		UserDetails currentUser= new UserDetails();
		UserDetails followingUser= new UserDetails();
		currentUser.setUserId(currentUserId);
		followingUser.setUserId(followingUserId);
		
		try {
			followingObj=followingRepo.findByUserAndFollowingUserId(currentUser, followingUser).get(0);
		}catch(Exception e) {
			isRealationShipPresent= false;	
		}
		
		if(isRealationShipPresent) {
			System.out.println(followingObj);
			followingRepo.delete(followingObj);
		}else {
			followingObj.setFollowingUserId(followingUser);
			followingObj.setUser(currentUser);
			followingRepo.save(followingObj);
		}
		
	}
	
	

}
