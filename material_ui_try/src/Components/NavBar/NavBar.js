import ShareIcon from '@material-ui/icons/Share';
import React, {Fragment, Component} from 'react';
import AppBar from '@material-ui/core/AppBar';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import ToolBar from '@material-ui/core/ToolBar';
import Box from '@material-ui/core/Box';
import Button from '@material-ui/core/Button';
import { withStyles } from '@material-ui/core/styles';
import {connect} from 'react-redux';
import {fetchUserFeed, updateNumUsers} from '../../ActionCreators/UserActions';
import Avatar from '@material-ui/core/Avatar';
import {Link} from 'react-router-dom';
import {subscribeToNotifications} from '../Utilities/notification';

const navStyle= {
  navbar: {
    backgroundColor: '#1f8b7e',
    height: '4rem'
  },
  grid1: {
    flexDirection: 'row',
    '& *':{
      display:'inline-block',
      verticalAlign: 'middle'
    }
  },
  toolbar: {
      justifyContent: 'space-between'
    },
    profileButton: {
      color: 'black',
      backgroundColor: 'lightblue',
      transition: '0.4s',
      '&:hover':{
          backgroundColor: 'blue'
      }
    }
  };

class NavBar extends Component {
  eventSrc=null;

  retriggerconnection(){

    if(!this.eventSrc){
    this.eventSrc=new EventSource("http://localhost:8080/give-random-data");

    this.eventSrc.addEventListener("my sse event", (eve) => {
      let finalNum=JSON.parse(eve.data).num;
      this.props.updatePollUsers(finalNum);
    });

    this.eventSrc.onopen = () => {
      console.log('atleast opened');
    }
  }
  }

  componentDidMount() {
        console.log('mount triggered');
//this.retriggerconnection();

        window.gapi.load('auth2', () => {
            window.gapi.auth2.init({
            client_id: '253897380785-95rbdhccmoa711fh0jbvi029hmocovoj.apps.googleusercontent.com'
        }).then(() => {
            window.gapi.signin2.render('my-signIn', {
              'scope': 'profile email',
              'width': 200,
              'height': 50,
              'longtitle': false,
              'theme': 'dark',
              'onsuccess': this.onSuccess,
              'onfailure': this.onFailure
            })
          })
        });
      }

    onSuccess = (googleUser) => {
    //   let name=googleUser.getBasicProfile().getName().split(' ')[0];
    //   let actName=name.charAt(0).toUpperCase() + name.slice(1);
        console.log('mailid is ',googleUser.getBasicProfile().getEmail());
        console.log('url is ', googleUser.getBasicProfile().getImageUrl());
        console.log('name is ',googleUser.getBasicProfile().getName().split(' ')[0]);


        this.props.fetchUserDetails(googleUser.getBasicProfile().getEmail());

    }

    // componentWillUnmount(){
    //   console.log('yes in unmount');
    //   this.eventSrc.close();
    // }

    // componentDidUpdate(){
    //   console.log('yes in unmount');
    //   this.eventSrc.close();
    //
    //   this.eventSrc=new EventSource("http://localhost:8080/give-random-data");
    //
    //   this.eventSrc.addEventListener("my sse event", (eve) => {
    //     let finalNum=JSON.parse(eve.data).num;
    //     this.props.updatePollUsers(finalNum);
    //   });
    //
    //   this.eventSrc.onopen = () => {
    //     console.log('atleast opened');
    //   }
    // }

    // componentDidUpdate(){
    //    console.log('yes in unmount');
    //    this.eventSrc.close();
    //
    //   this.retriggerconnection();
    //  }

    render() {
      console.log(this.props.numUsers);
      let navBarRightSection = (
        <Grid className={this.props.classes.grid1}>
            <Box  id="my-signIn" />
        </Grid>
      );

      if(this.props.isAuth){
          navBarRightSection= (
              <Button variant="outlined" className={this.props.classes.profileButton}>

                  <Typography variant="h6">{this.props.userName}</Typography>
                  <Avatar alt="user-image" src={this.props.userImage} />

              </Button>
          );
      }

      return (
      <Fragment>
      <AppBar position="static" className={this.props.classes.navbar}>
        <ToolBar className={this.props.classes.toolbar}>
          <Grid className={this.props.classes.grid1}>
            <IconButton edge="start" color="inherit" aria-label="menu">
              <ShareIcon />
            </IconButton>
            <Typography variant='h5'>
            <Link to='/' style={{color:'white','textDecoration':'none'}}>NextConnect</Link>
            </Typography>
            <Typography variant='h5'>Num Users Supporting: {this.props.numUsers}</Typography>
            <Button variant='contained' onClick={() => subscribeToNotifications(this.props.userId)}
             color={this.props.feedNotifications ? 'secondary' : 'primary'}
            >{this.props.feedNotifications ? 'UNSUBSCRIBE' : 'SUBSCRIBE'}</Button>
          </Grid>
          {navBarRightSection}
        </ToolBar>
      </AppBar>
      </Fragment>
    );

  }
}

const mapStateToProps = (state) => {
  return {userName: state.user.userName,
  userImage: state.user.userImageUrl,
  isAuth: state.user.isAuthenticated,
  numUsers: state.user.pollNumber,
  feedNotifications: state.user.feedNotifications,
  userId: state.user.userId
  };
}

const mapDispatchToProps = (dispatch) => {
  return {
    fetchUserDetails : (mailId) => { dispatch(fetchUserFeed(mailId))},
    updatePollUsers: (numUsers) => {dispatch(updateNumUsers(numUsers))}
  };
}


export default connect(mapStateToProps, mapDispatchToProps)(withStyles(navStyle)(NavBar));
