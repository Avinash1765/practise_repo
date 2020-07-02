import React, {PureComponent} from 'react';
import {withStyles} from '@material-ui/core/styles';
import {connect} from 'react-redux';
import CreatePost from '../../Components/CreatePost/CreatePost';
import {storePostToDB} from '../../ActionCreators/PostsActions';
import {fetchBrowseUsers} from '../../ActionCreators/UserActions';
import {CREATING_POST_FLAG} from '../../NextConnectConstants';
import UserFeedPosts from '../UserFeedPosts/UserFeedPosts';
import BrowserUsers from '../../Components/BrowseUsers/BrowseUsers';
import Snackbar from '@material-ui/core/Snackbar';
import {updateFollowingStatus} from '../../ActionCreators/UserActions';

const userFeedStyles= {
    outerDiv: {
      width: '55%',
      marginLeft: '1rem',
    }
};


class UserFeed extends PureComponent {

  constructor(){
    super();
    this.state= {
      currentPageNum: 0,
      isLoading: false,
      showSnackBar: false,
      followingUser: ''
    }
  }

  finalUsersToDispay = () => {
    return this.props.browseUserList[this.state.currentPageNum] ?
      this.props.browseUserList[this.state.currentPageNum]: [];
  }

  getNextPageDetails = (nextPageNum) => {
    this.setState({'isLoading': true});
    if(!this.props.browseUserList[nextPageNum]){
        this.props.fetchCurrentPageUsers(nextPageNum);
    }
    this.setState({'isLoading': false});
    this.setState({currentPageNum: nextPageNum});
  }

  followUser = (userId, userName, followingUserData) => {
      this.setState({showSnackBar: true, followingUser: userName});
      this.props.toggleFollowing(this.props.userId, userId, followingUserData);
  }

  closeSnackBar = ()=> {
    this.setState({showSnackBar: false});
  }

  submitPost = (postContent, userId= this.props.userId) => {
      this.props.postCreationStateUpdate();
      console.log(postContent, userId);

      this.props.storePost(postContent, this.props.userId);
  }

  componentDidMount(){
    this.getNextPageDetails(0);
  }

  render(){
      const {userImageUrl, userName} = this.props;
  return (
    <div className={this.props.classes.outerDiv}>
            <CreatePost userImageUrl={userImageUrl} userName={userName}
            submitPostMethod={this.submitPost} isCreatingPost={this.props.creatingPost}/>
            <UserFeedPosts />
            <BrowserUsers currentPageNum={this.state.currentPageNum}
            userList={this.finalUsersToDispay()}
            getNextPageDetails= {this.getNextPageDetails} isLoading={this.state.isLoading}
            followUser={this.followUser}/>

            <Snackbar
              anchorOrigin={{ vertical: 'bottom', 'horizontal':'left'}}
              open={this.state.showSnackBar}
              message={"Following "+ this.state.followingUser}
              autoHideDuration={6000}
              onClose={this.closeSnackBar}
              key='bottom left' />
    </div>
  );

  }
}

const mapStateToProps= (state) => {
  return {
    userImageUrl: state.user.userImageUrl,
    userName: state.user.userName,
    userId: state.user.userId,
    creatingPost: state.post.creatingPost,
    browseUserList: state.user.browseUserList
  }
}

const mapDispatchToProps= (dispatch) => {
  return {
      storePost: (postContent, userId) => dispatch(storePostToDB(postContent, userId)),
      postCreationStateUpdate: () => dispatch({type: CREATING_POST_FLAG}),
      fetchCurrentPageUsers: (nextPageNum) => dispatch(fetchBrowseUsers(nextPageNum)),
      toggleFollowing: (userId, followingUserId, followingUserData) => dispatch(updateFollowingStatus(userId, followingUserId, true,followingUserData))
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(withStyles(userFeedStyles)(UserFeed));
