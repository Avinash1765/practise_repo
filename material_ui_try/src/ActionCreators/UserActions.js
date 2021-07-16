import {USER_FEED_UPDATE, TOGGLE_FOLLOWING, FETCH_BROWSE_USERS, POLL_DATA} from '../NextConnectConstants';
import axios from '../axios/axiosinstance';

function updateUserDetails(userFeedObj) {
  return {
    type: USER_FEED_UPDATE,
    data: userFeedObj
  }
}

function updateUserFollowingInStore(followingUserId, followingFlag, followingUserData){
  return {type: TOGGLE_FOLLOWING, data: followingUserId, followingFlag: followingFlag, followingUserData: followingUserData };
}

function updateUsersToBrowseInStore(pageNum, userList){
  return {type: FETCH_BROWSE_USERS, data: {pageNum: pageNum , userList:userList}};
}

function updateNumUsers(numUsers){
//  console.log(numUsers);
  return {type: POLL_DATA, data: {num: numUsers}};
}


export function fetchUserFeed(userMailId){
    console.log(userMailId);
    return function(dispatch){
      axios.get('/get-user-details', {
        params:{
          userMailId: userMailId}
      }).then((response) => {
          console.log(response.data);
          dispatch(updateUserDetails(response.data));
      }).catch((error) => {
        console.log('actually buddy, error occured ', error);
      });
    }
}

function updateFollowingStatus(currentUserId, followingUserId, followingFlag
            , followingUserData={}){
  console.log(' in user actions ');
  return function(dispatch){
        console.log(' in update following status ');
        axios.get('/toggle-follower', {
          params: {
            'currentUserId': currentUserId,
            'followingUserId': followingUserId
          }
        }).then((response) => {
            dispatch(updateUserFollowingInStore(followingUserId, followingFlag, followingUserData));
        })
  }
}

function fetchBrowseUsers(pageNum){
    return function(dispatch){
      axios.get('/get-user-list', {params:{'pageNo': pageNum}})
      .then((response) => {
          dispatch(updateUsersToBrowseInStore(pageNum, response.data));
      }).catch((err) => {
        console.log(err);
      })
    }
}

export {updateUserDetails, updateFollowingStatus, fetchBrowseUsers, updateNumUsers};
