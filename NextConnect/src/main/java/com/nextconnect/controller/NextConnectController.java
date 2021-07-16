package com.nextconnect.controller;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter.SseEventBuilder;

import com.nextconnect.config.FcmClient;
import com.nextconnect.constants.NextConnectConstants;
import com.nextconnect.constants.StatusEnum;
import com.nextconnect.dto.Comments;
import com.nextconnect.dto.Following;
import com.nextconnect.dto.Joke;
import com.nextconnect.dto.MessagingToken;
import com.nextconnect.dto.Post;
import com.nextconnect.dto.UserDetails;
import com.nextconnect.dto.UserFeedDto;
import com.nextconnect.repos.BrowseUserRepo;
import com.nextconnect.repos.CommentsRepo;
import com.nextconnect.repos.FollowingRepo;
import com.nextconnect.repos.PostRepo;
import com.nextconnect.repos.TokenRepo;
import com.nextconnect.repos.UserRepository;
import com.nextconnect.service.LikeUpdateService;


@RestController
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
	
	@Autowired
	private BrowseUserRepo browserUserRepo;
	
	@Autowired
	private TokenRepo tokenRepo;
	
	@Autowired
	private FcmClient fcmClient;
	
	/*
	 * @Autowired private SseEmitter emitterBkup;
	 */
	
	@Qualifier(value = "myRestClient")
	@Autowired
	private RestTemplate restTemplate;
	
	private Set<SseEmitter> emiterSet= new HashSet<>();
	
	@Scheduled(fixedDelay = 30000)
	public void fetchJokeAndPushNotification() {
		ResponseEntity<Joke> respObj=restTemplate.getForEntity("http://api.icndb.com/jokes/random", Joke.class);
		System.out.println(respObj);
		
		Map<String, String> map=new HashMap<>();
		map.put("my joke is ", respObj.getBody().getJokeData().getJoke());
		try {
			fcmClient.send(map);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/give-random-data")
	public SseEmitter publishRandomNumbers() {
		
		SseEmitter emitterBkup= new SseEmitter();
		
		emiterSet.add(emitterBkup);
		
		emitterBkup.onCompletion(() -> {
			System.out.println("did reached here");
			emiterSet.remove(emitterBkup);
		});
		//emitterBkup= emitterBkup == null ? new SseEmitter(Long.MAX_VALUE) : emitterBkup;
		
		ExecutorService executor= Executors.newSingleThreadExecutor();
		
		executor.execute(() -> {
			
			for(;true;) {
			try {
			Thread.sleep(3000);
			
			double val=Math.random() * 600;
			
			Integer finalVal=400 + ((int)val);
			
			SseEventBuilder event = SseEmitter.event().data(new MyData().setNum(finalVal)).name("my sse event");
			System.out.println("from scheuled task" + finalVal);
			
			for(SseEmitter currentEmitter: emiterSet) {
				System.out.println(" emitter set size "+emiterSet.size()+ " and thered name:: "+ Thread.currentThread().getName());
				currentEmitter.send(event);
			}
			}catch(Exception e) {
				System.out.println("unexpected in "+ e);		
			}		
			}
		});
		return emitterBkup;
	}
	
	@GetMapping(path = "/store-token")
	public void storeTokenInDB(@RequestParam("MSG_TOKEN") String messagingToken, @RequestParam("USER_ID") Integer userId) {
		MessagingToken msgToken= new MessagingToken();
		msgToken.setMessagingToken(messagingToken);
		
		UserDetails udet= new UserDetails();
		udet.setUserId(userId);
		msgToken.setUser(udet);
		
		MessagingToken savedToken=tokenRepo.save(msgToken);
		
		System.out.println(savedToken);
	}
	
	@RequestMapping(value="/get-user-list")
	public List<UserDetails> findUsersToBrowse(@RequestParam("pageNo") Integer pageNum, 
			@RequestParam(name = "pageSize", required = false, defaultValue = NextConnectConstants.PAGE_NUM_DEFAULT_SIZE) Integer pageSize){
		Pageable pageable= PageRequest.of(pageNum, pageSize, Sort.by("userId"));
		Page<UserDetails> userDetailsPage=browserUserRepo.findAll(pageable);
		
		System.out.println(userDetailsPage);
		
		return userDetailsPage.get().collect(Collectors.toList());
	}

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

class MyData {
	private Integer num;

	public int getNum() {
		return num;
	}

	public MyData setNum(Integer num) {
		MyData obj=new MyData();
		 obj.num= num;
		 return obj;
		//this.num = num;
	}
	
	public MyData() {}
	
}
