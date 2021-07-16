import Post from '../../Components/Post/Post';
import Box from '@material-ui/core/Box';
import React from 'react';
import {updatePosts} from '../../ActionCreators/PostsActions.js';
import {connect} from 'react-redux';

class UserFeedPosts extends React.PureComponent {

  componentDidMount() {
     this.updatePostTime = setInterval(() => this.props.updatePostTiming(this.props.posts), 1000 * 60);
  }

  componentWillUnmount() {
     clearInterval(this.updatePostTime);
  }

  render() {
  //  console.log('user posts rendered');
    return this.props.posts.map((post) => {
      return (
        <Box key = {post.postId} ><Post post = {post} currentUserId={this.props.currentUserId} currentUserImage={this.props.currentUserImage}/></Box>
      );
    })
  }
}

const mapDispatchToProps = (dispatch) => {
    return {updatePostTiming : (posts) => dispatch(updatePosts(posts)) }
}

const mapStateToProps = (state) => {
  return {
    posts : state.post.posts,
    currentUserImage: state.user.userImageUrl,
    currentUserId: state.user.userId
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(UserFeedPosts);
