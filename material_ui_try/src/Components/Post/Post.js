import React from 'react';
import Box from '@material-ui/core/Box';
import Avatar from '@material-ui/core/Avatar';
import {Link} from 'react-router-dom';
import Grid from '@material-ui/core/Grid';
import {makeStyles} from '@material-ui/core/styles';
import {LIKE_ICON_CONTENT, COMMENT_COUNT} from '../../NextConnectConstants';
import {useEffect, useRef} from 'react';
import Comment from '../Comment/Comment';
import {updateLikeC} from '../../ActionCreators/PostsActions';
import {useDispatch} from 'react-redux';

const postStyles = makeStyles({
    postContainer : {
      backgroundColor: '#f2f3fa',
      display: 'flex',
      flexDirection: 'row',
      height: '3.5rem',
      fontSize:'0.9rem'
    },
    userProfileLink: {
      display: 'block'
    },
    overAllPostContainer: {
        marginTop: '0.8rem',
      '& p': {
        margin: 0,
        marginTop: '0.8rem'
      }
    },
    numLikesBadgeClass: {
      position: 'relative',
      color: 'black',
      width: '2rem',
      height: '2rem',
      display: 'inline-block',
      marginRight: '2rem'
    },
    psuedoClass:{
      '&::after': {
        position: 'absolute',
        top: '-6px',
        right: '2px',
        content: 'attr('+ LIKE_ICON_CONTENT +')' ,
        width: '1.1rem',
        height: '1.1rem',
        borderRadius: '50%',
        backgroundColor: 'red',
        color: 'white',
        'textAlign':'center'
      }
    },
    commentIconClass: {
      position: 'relative',
      color: 'rgb(0,0,0)',
      width: '2rem',
      height: '2rem',
      display: 'inline-block',
      marginRight: '2rem'
    },
    commentIconditionClass:{
      '&::after': {
        position: 'absolute',
        top: '-6px',
        right: '2px',
        content: 'attr('+ COMMENT_COUNT +')' ,
        width: '1.1rem',
        height: '1.1rem',
        borderRadius: '50%',
        backgroundColor: 'red',
        color: 'white',
        'textAlign':'center'
      }
    },
    commentBox: {
      backgroundColor: '#f2f3fa'
    },
    postContentContainer: {
        paddingLeft: '1.5rem'
    }
});

function post(props) {
      console.log('post id ', props.post.postCreationString);
      const dispatch= useDispatch();

      let likeIconRef= null;
      let commentIconRef= useRef(null);

      useEffect(() => {

          if(props.post.numLikes > 0){
              likeIconRef.current.classList.add(classes.psuedoClass);
              likeIconRef.current.setAttribute(LIKE_ICON_CONTENT, props.post.numLikes);
          }

          if(props.post.postComments.length > 0) {
            commentIconRef.current.classList.add(classes.commentIconditionClass);
            commentIconRef.current.setAttribute(COMMENT_COUNT, props.post.postComments.length);
          }
      });

      likeIconRef = useRef(null);
      const classes= postStyles();

      const likeIconClassArr=['far','fa-heart', classes.numLikesBadgeClass];
      const commentIconClasses=['far','fa-comments', classes.commentIconClass].join(' ');

      const likedUserIdList= props.post.likeDetails.map((likeObj) => likeObj.likeDetail.userId);

      if(likedUserIdList.includes(props.post.postedBy.userId)) {
        likeIconClassArr[0]= 'fas';
      }

      const likeIconClasses= likeIconClassArr.join(' ');
      console.log('currentUserId in post '+ props.currentUserId);
      return (
        <Box boxShadow={3} className={classes.overAllPostContainer}>
            <Box className={classes.postContainer}>
                <Grid item style={{'padding':'0.8rem'}}>
                <Avatar src={props.post.postedBy.userImageUrl} alt={props.post.postedBy.userName}/>
                </Grid>
                <Grid>
                    <Link to={'/userProfile/'+props.post.postedBy.userId} className={classes.userProfileLink} >{props.post.postedBy.userName}</Link>
                    <p>{props.post.postCreationString}</p>
                </Grid>
            </Box>
            <Box className={classes.postContentContainer}>
                <p>{props.post.postContent}</p><br/>
                <a href="#" onClick={(event) => {
                  event.preventDefault();
                  dispatch(updateLikeC(props.post.postId, props.currentUserId));
                }}><i className={likeIconClasses} ref={likeIconRef}></i></a>
                <i className={commentIconClasses} ref={commentIconRef}></i><br/>
            </Box>
            <Box className={classes.commentBox}>
                <Comment type='userInputComment' userImageUrl={props.currentUserImage} postId={props.post.postId}/>

                {props.post.postComments.map(postComment => {
                    return (<Comment key={postComment.commentId} type='preFilledComment' userImageUrl= {postComment.commentedUser.userImageUrl}
                    commentedUserName={postComment.commentedUser.userName}
                      commentText={postComment.commentText} commentByUserId= {postComment.commentedUser.userId} />);
                }) }
            </Box>
        </Box>
      );
}

export default React.memo(post);
