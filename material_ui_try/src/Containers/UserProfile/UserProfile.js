import React, {PureComponent} from 'react';
import Card from '@material-ui/core/Card';
import {withStyles} from '@material-ui/core/styles';
import Avatar from '@material-ui/core/Avatar';
import Tab from '@material-ui/core/Tab';
import Tabs from '@material-ui/core/Tabs';
import TabPanel from '../../Components/TabPanels/TabPanel';
import Post from '../../Components/Post/Post';
import {Link} from 'react-router-dom';
import Button from '@material-ui/core/Button';
import {updateFollowingStatus} from '../../ActionCreators/UserActions';
import {connect} from 'react-redux';
import Snackbar from '@material-ui/core/Snackbar';

const userProfileStyle = {
      'UserProfileContainer':{
          'width': '40%',
          'margin': '0 auto',
          'marginTop':'0.5rem'
      },
      'userMetadata':{
        'display':'flex',
        'fontSize': '0.8rem',
        '& i':{
          'textAlign':'right',
          'display': 'block',
          'fontSize':'1.2rem',
          'lineHeight':'2.3rem',
          'flexBasis':'100%'
        }
      }
};


class UserProfile extends PureComponent {

        constructor(){
            super();
            this.state={
                tabValue: 0,
                userFollowFlag: true,
                showSnackBar: false
            };
        }

        tabChangeHandler = (event, newValue) => {
            this.setState({tabValue: newValue});
        }

        closeSnackBar = ()=> {
          this.setState({showSnackBar: false});
        }


        changeFollowingStatus =() => {
          let finalStateToSet= true;
          this.setState((prevState) => {
              finalStateToSet= !prevState.userFollowFlag;
              if(!finalStateToSet){
                  this.props.removeUserFollowing(this.props.currentUserId, this.props.userId);
              }
              return {prevState, userFollowFlag: finalStateToSet, showSnackBar: !prevState.showSnackBar};
          });
        }

        render(){
          console.log(this.props);
          return(
            <Card className={this.props.classes.UserProfileContainer}>
                <h1 style={{color:'#2a7a6c', 'textAlign':'center'}}>Profile</h1>
                <div className={this.props.classes.userMetadata}>
                    <Avatar src={this.props.userImageUrl} alt='user-image' style={{display: 'inline-block', margin: '0.6rem'}} />
                    <div>
                          <p>{this.props.userName}</p>
                          <p>{this.props.userMailId}</p>
                    </div>
                      {this.props.currentUserFlag ?
                    <div style={{'display':'flex', 'justifyContent':'flex-end', 'flexWrap':'wrap', 'flexGrow':'1'}}>
                       <i className="far fa-edit"></i>
                        <i className="far fa-trash-alt"></i>
                    </div> :
                    <div style={{'display':'flex','flexDirection':'row-reverse','flexGrow':'1'}}>
                      {this.state.userFollowFlag ?
                          <Button style={{'display':'inline-block'}}
                          onClick={() => this.changeFollowingStatus()}
                          variant='contained' color='secondary'>UNFOLLOW</Button> : null }
                    </div> }
                </div>
                <hr />

                <div>
                <Tabs value={this.state.tabValue} onChange={this.tabChangeHandler} aria-label="simple tabs example" variant='fullWidth'>
                    <Tab label="POSTS"  />
                    <Tab label="FOLLOWING" />
                    <Tab label="FOLLOWERS" />
                </Tabs>
                <TabPanel value={this.state.tabValue} index={0} >
                    <div>  {
                        this.props.posts.map((postObj) => {
                              return <Post post = {postObj} currentUserId={this.props.currentUserId} currentUserImage={this.props.currentUserImage}/>; })
                            }
                    </div>
                </TabPanel>
                <TabPanel value={this.state.tabValue} index={1}>
                        {
                          this.props.followingUsers.map((followingUser) => {
                            return (
                              <div key={followingUser.userId} style={{'display':'inline-block','padding':'1rem','textAlign':'center'}}>
                                  <Avatar src={followingUser.userImageUrl} alt={'following-user '+ followingUser.userName} />
                                  <Link to={'/UserProfile/'+followingUser.userId}>{followingUser.userName}</Link>
                              </div>
                            );
                          })
                        }
                </TabPanel>
                </div>
                <Snackbar
                  anchorOrigin={{ vertical: 'bottom', 'horizontal':'left'}}
                  open={this.state.showSnackBar}
                  message="Unfollowed "
                  autoHideDuration={6000}
                  onClose={this.closeSnackBar}
                  key='bottom left' />
            </Card>
          );
        }
}


const mapDispatchToProps = (dispatch) => {
      return {
        removeUserFollowing: (userId, followingUserId) => {dispatch(updateFollowingStatus(userId, followingUserId, false))}
      }
}


export default connect(null, mapDispatchToProps)(withStyles(userProfileStyle)(UserProfile));
