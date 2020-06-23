import {USER_FEED_UPDATE, FETCH_BROWSE_USERS, CREATE_POST,CREATING_POST_FLAG, UPDATE_POSTS, STORE_COMMENT, UPDATE_LIKE, TOGGLE_FOLLOWING} from '../NextConnectConstants';


const initialState = {
      userMailId: null,
      userName: null,
      userImageUrl: null,
      isAuthenticated: false,
      userId: null,
      posts:[],
      creatingPost: false,
      followingUserList: null,
      browseUserList: {}
};

const updateTimingString = (posCreationMillis) => {
let currentTimeMillis = new Date().getTime();

let timeDiffMillis = (currentTimeMillis - posCreationMillis) / 1000;

if (timeDiffMillis < 60) {
  return "less than " + Math.floor(timeDiffMillis + 1) + " seconds ago";
} else if (timeDiffMillis >= 60 && timeDiffMillis < 3600) {
  return "less than " + Math.floor((timeDiffMillis / 60) + 1) + " minutes ago";
} else if (timeDiffMillis >= 3600 && timeDiffMillis < 86400) {
  return "less than " + Math.floor((timeDiffMillis / 3600) + 1) + " hours ago";
} else {
  return "less than " + Math.floor((timeDiffMillis / 86400) + 1) + " days ago";
}
}

const reducer= (state = initialState, action) => {

      if(action.type === TOGGLE_FOLLOWING){
        if(!action.followingFlag){
            let newState= {...state};
            let newPosts= [...state.posts];
            let newFollowingUsers= [...state.followingUserList]
            newPosts=newPosts.filter((postObj) => postObj.postedBy.userId !== action.data);
            newFollowingUsers=newFollowingUsers.filter((followingUserObj) => followingUserObj.userId !== action.data);
            newState.posts= newPosts;
            newState.followingUsers= newFollowingUsers;
            return newState;
          }else{
            let newUserData= action.followingUserData;
            let newState= {...state};
            let newFollowingUsers= [...state.followingUserList];
            newFollowingUsers.push(newUserData);
            newState.followingUsers= newFollowingUsers;
            console.log(newState);
            return newState;
          }
      }

      if(action.type === UPDATE_LIKE){
        let newState= {...state};
        let newPosts= [...newState.posts];
        let targetPostIndex= -1;

        for(let i=0;i< newState.posts.length; i++){
            if(newState.posts[i].postId === action.data.postId){
              targetPostIndex= i;
              break;
            }
        }

        let targetPost= {...newPosts[targetPostIndex]};
        let newLikeDetails= [];

        for(let i=0;i< targetPost.likeDetails.length; i++){
            newLikeDetails.push({...targetPost.likeDetails[i]});
        }

        const isLikedByCurrentUser= newLikeDetails.filter((likeObj) => likeObj.likeDetail.userId=== action.data.userId).length > 0;

        if(isLikedByCurrentUser){
            newLikeDetails=targetPost.likeDetails.filter((likeObj) => likeObj.likeDetail.userId !== action.data.userId);
            targetPost.numLikes -=1;
        }else{
            newLikeDetails.push({'likeDetail':{'userId': action.data.userId}});
            targetPost.numLikes +=1;
        }

        targetPost.likeDetails = newLikeDetails;
        newPosts[targetPostIndex]= targetPost;
        newState.posts= newPosts;
        return newState;
      }

      if(action.type === STORE_COMMENT){
        let commentRespObj= action.data;
        let targetPostIndex= -1;
        commentRespObj['commentedUser']['userName'] = state.userName;
        commentRespObj['commentedUser']['userImageUrl']= state.userImageUrl;
        commentRespObj['commentedUser']['emailId']= state.userMailId;

        let newState= {...state};
        let newPostArr= [...state.posts];

        // let actualPost = newPostArr.forEach((item, i) => {
        //     if(item.postId === action.data.postId){
        //           targetPostIndex= i;
        //           break;
        //     }
        // });

        for(let i=0; i< newPostArr.length; i++){
          if(newPostArr[i].postId === action.data.postId){
                   targetPostIndex= i;
                   break;
          }
        }

        let targetPost= {...newPostArr[targetPostIndex]};

        let finalComments = [...targetPost.postComments];
        finalComments.unshift(commentRespObj);
        targetPost.postComments= finalComments;
        newPostArr[targetPostIndex]= targetPost;
        newState.posts= newPostArr;

        return newState;

      }

      if(action.type === CREATING_POST_FLAG){
          let newState= {...state, creatingPost: !state.creatingPost};
          return newState;
      }
      if(action.type === USER_FEED_UPDATE){
        let newState = {...state,
          userName: action.data.userDetails.userName,
            userImageUrl: action.data.userDetails.userImageUrl,
             isAuthenticated: true,
             userId: action.data.userDetails.userId,
             posts: action.data.userPosts,
             followingUserList: action.data.followingUsers,
             userMailId: action.data.userDetails.emailId
           };

           newState.posts.forEach((post) => {
             let posCreationTime = post.postCreationMillis;
             let postTimingStamp = updateTimingString(posCreationTime);
             post['postCreationString']= postTimingStamp;
           });

        return newState;
      }

      if(action.type === CREATE_POST){
        let newState= {...state};
        let newPosts= [...state.posts];
        action.data.postCreationString = 'less than 5 seconds ago';
        newPosts.push(action.data);
        newState.posts= newPosts;
        return newState;
      }

      if(action.type === UPDATE_POSTS) {
        let newState = {...state};
        let newPostArr=[];

        action.data.forEach((post) => {
          let posCreationTime = post.postCreationMillis;
          let postTimingStamp = updateTimingString(posCreationTime);
          let newPost={...post};
          newPost['postCreationString']= postTimingStamp;
          newPostArr.push(newPost);
        });

        newState.posts= newPostArr;
        return newState;
      }

      if(action.type === FETCH_BROWSE_USERS) {
        let newState = {...state};
        let newBrowseUserList= {...state.browseUserList};
        newBrowseUserList[action.data.pageNum] = action.data.userList;
        newState.browseUserList = newBrowseUserList;
        return newState;
      }
      return state;
}

export default reducer;
