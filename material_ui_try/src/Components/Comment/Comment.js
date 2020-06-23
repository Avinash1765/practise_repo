import React, {Fragment} from 'react';
import Avatar from '@material-ui/core/Avatar';
import TextField from '@material-ui/core/TextField';
import {makeStyles} from '@material-ui/core/styles';
import Grid from '@material-ui/core/Grid';
import {Link} from 'react-router-dom';
import {useRef, useEffect} from 'react';
import {useSelector, useDispatch} from 'react-redux';
import createCommentInDB from '../../ActionCreators/CommentActions';

  const commentStyles= makeStyles({
      'userAvatar' : {
          display: 'inline-block',
          padding: '1rem'      
      },
      'commentInput': {
          display: 'inline-block'
      },
      'commentData': {
          display: 'flex',
      }
  });

const comment= ({postId, type, userImageUrl, commentByUserId, commentText, commentedUserName, commentSubmitFn}) => {

  const userId=useSelector(state => state.userId);
  const dispatch= useDispatch();

  const commentTextRef= useRef({});

  useEffect(() => {
    //  console.log(commentTextRef.current);
      commentTextRef.current.value='';
  });

  const createComment= (event) => {
    if(event.keyCode === 13){
          event.preventDefault();
          let commentText= commentTextRef.current.value;
          dispatch(createCommentInDB(commentText, userId, postId));
      }
  }

  const classes=commentStyles();

    if(type=== 'userInputComment') {
      return (
          <div className={classes.commentData}>
              <Avatar src={userImageUrl} alt="user-image" className={classes.userAvatar} />
              <TextField id="standard-search" inputRef={commentTextRef}
              label="Comment" type="search" className={classes.commentInput} onKeyUp={createComment}/>
          </div>
      );
    }
    else {
      return (
        <div className={classes.commentData}>
            <Avatar src={userImageUrl} alt="user-image" className={classes.userAvatar}/>
            <Grid style={{'display':'inline-block'}}>
                <Link to={'/UserProfile/'+commentByUserId}>{commentedUserName}</Link>
                <p>{commentText}</p>
            </Grid>
      </div>
    );
  }
}

export default comment;
