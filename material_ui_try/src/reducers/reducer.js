import {USER_FEED_UPDATE, FETCH_BROWSE_USERS, TOGGLE_FOLLOWING} from '../NextConnectConstants';


const initialState = {
      userMailId: null,
      userName: null,
      userImageUrl: null,
      isAuthenticated: false,
      userId: null,
      followingUserList: null,
      browseUserList: {}
};


const reducer= (state = initialState, action) => {

      if(action.type === TOGGLE_FOLLOWING){
        if(!action.followingFlag){
            let newState= {...state};
      //      let newPosts= [...state.posts];
            let newFollowingUsers= [...state.followingUserList]
          //  newPosts=newPosts.filter((postObj) => postObj.postedBy.userId !== action.data);
            newFollowingUsers=newFollowingUsers.filter((followingUserObj) => followingUserObj.userId !== action.data);
          //  newState.posts= newPosts;
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

    //  if(action.type === UPDATE_LIKE){
        // let newState= {...state};
        // let newPosts= [...newState.posts];
        // let targetPostIndex= -1;

        // for(let i=0;i< newState.posts.length; i++){
        //     if(newState.posts[i].postId === action.data.postId){
        //       targetPostIndex= i;
        //       break;
        //     }
        // }

      //  let targetPost= {...newPosts[targetPostIndex]};
        // let newLikeDetails= [];
        //
        // for(let i=0;i< targetPost.likeDetails.length; i++){
        //     newLikeDetails.push({...targetPost.likeDetails[i]});
        // }

        // const isLikedByCurrentUser= newLikeDetails.filter((likeObj) => likeObj.likeDetail.userId=== action.data.userId).length > 0;
        //
        // if(isLikedByCurrentUser){
        //     newLikeDetails=targetPost.likeDetails.filter((likeObj) => likeObj.likeDetail.userId !== action.data.userId);
        //     targetPost.numLikes -=1;
        // }else{
        //     newLikeDetails.push({'likeDetail':{'userId': action.data.userId}});
        //     targetPost.numLikes +=1;
        // }
        //
        // targetPost.likeDetails = newLikeDetails;
        // newPosts[targetPostIndex]= targetPost;
        // newState.posts= newPosts;
        // return newState;
  //    }




      if(action.type === USER_FEED_UPDATE){
        let newState = {...state,
          userName: action.data.userDetails.userName,
            userImageUrl: action.data.userDetails.userImageUrl,
             isAuthenticated: true,
             userId: action.data.userDetails.userId,
          //   posts: action.data.userPosts,
             followingUserList: action.data.followingUsers,
             userMailId: action.data.userDetails.emailId
           };

           // newState.posts.forEach((post) => {
           //   let posCreationTime = post.postCreationMillis;
           //   let postTimingStamp = updateTimingString(posCreationTime);
           //   post['postCreationString']= postTimingStamp;
           // });

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
