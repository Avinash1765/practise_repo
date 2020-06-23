import axios from '../axios/axiosinstance';
import {STORE_COMMENT} from '../NextConnectConstants';
export default function createCommentInDB(commentText, userId, postId){

  let commentPostObj= {};
  commentPostObj['commentText']= commentText;

  let commentPost= {};
  commentPost['postId']= postId;
  commentPostObj['post']= commentPost;

  let commentUser= {};
  commentUser['userId']= userId;
  commentPostObj['commentedUser']= commentUser;

  return function(dispatch){
      axios.post('/add-comment', commentPostObj).then((response) => {
            dispatch(storeCommentInStore(response.data));
        }).catch((error) => {
          console.log(error);
        })
  }

}

function storeCommentInStore(commentRespObj){
    return {type: STORE_COMMENT, data: commentRespObj};
}
