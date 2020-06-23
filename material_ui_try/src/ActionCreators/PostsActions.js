import {CREATE_POST, CREATING_POST_FLAG, UPDATE_POSTS, UPDATE_LIKE} from '../NextConnectConstants';
import axios from '../axios/axiosinstance';

export const createPost = (postObject) => {
  return {type: CREATE_POST, data: postObject};
}

export const storePostToDB = (postContent, userId) => {

  let createPostBody= {};
  createPostBody['postedBy']= {};
  createPostBody['postContent']= postContent;
  createPostBody.postedBy.userId= userId;

  return function(dispatch){
      axios.post('/create-post', createPostBody).then((response) => {
          dispatch(createPost(response.data));
          dispatch({type: CREATING_POST_FLAG});
      }).catch((error) => {

      })
  }
}

export const updatePosts = (posts) => {
  return {type: UPDATE_POSTS, data: posts};
}

const updateLikeCount = (postId, userId) => {
  return {type: UPDATE_LIKE, data: {postId: postId, userId: userId}};
}

export const updateLikeC= (post_id, user_id) => {
    console.log('postId is '+ post_id);
    console.log('userId is '+ user_id);
    return function(dispatch){

      dispatch(updateLikeCount(post_id, user_id));

      axios.get('/new-like/'+post_id+'/'+user_id).then((response) => {
            console.log('update like operation successful ');
      }).catch((error) => {
          console.log('actually, error occured while updating like count in DB');
      })
    }
}
