import React, {PureComponent} from 'react';
import UserProfile from './UserProfile';
import {connect} from 'react-redux';
class UserProfileWrapper extends PureComponent {

  constructor(){
    super();
    this.currentUserFlag= true;
  }

  render(){
      let userId= parseInt(this.props.match.params.userId,10);
      let userName= this.props.userName;
      let postsToShow= this.props.posts;
      let userMailId= this.props.userMailId;
      let userImageUrl= this.props.userImageUrl;
      let followingUserListToShow= this.props.followingUserList;
      this.currentUserFlag = (userId === this.props.currentUserId);

      if(!this.currentUserFlag){
            postsToShow= postsToShow.filter((postObj) => {
              return postObj.postedBy.userId === userId;
            });

            let userToDisplay= this.props.followingUserList.find(followingUser => {
              return followingUser.userId === userId;
            });
            followingUserListToShow= [];
            userName= userToDisplay.userName;
            userMailId= userToDisplay.emailId;
            userImageUrl= userToDisplay.userImageUrl;
    }

    console.log(postsToShow);

        return (
        <UserProfile currentUserFlag= {this.currentUserFlag} userId= {userId} userName={userName} userMailId={userMailId} posts={postsToShow}
              userImageUrl={userImageUrl} followingUsers={followingUserListToShow} currentUserId={this.props.currentUserId} currentUserImage={this.props.userImageUrl}/>);

  }

}

const mapStateToProps = (state) => {
  return {
    currentUserId: state.user.userId,
    userMailId: state.user.userMailId,
    userName: state.user.userName,
    userImageUrl: state.user.userImageUrl,
    posts: state.post.posts,
    followingUserList: state.user.followingUserList
  }
}

export default connect(mapStateToProps)(UserProfileWrapper);
