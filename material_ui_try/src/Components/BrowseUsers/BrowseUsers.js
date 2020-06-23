import React from 'react';
import Button from '@material-ui/core/Button';
import Avatar from '@material-ui/core/Avatar';
import {makeStyles} from '@material-ui/core/styles';

const BrowseUserStyles = makeStyles({
  'container':{
      position: 'absolute',
      top: '4rem',
      right:0,
      'width':'20%'
    },
    'userContainer':{
        'display':'flex',
        'alignItems':'center',
        'justifyContent':'space-between',
        'flexDirection':'row',
        '& button':{
          'padding': '3px 8px',
          'border':'none',
          'color':'white'
        }
    }
});

const browseUsers = ({currentPageNum, userList, getNextPageDetails, isLoading, followUser}) => {
  const classes= BrowseUserStyles();

  return (
    <div className={classes.container}>
        <h4 style={{'textAlign':'center', 'color': '#43afa4'}}>Browser Users</h4><hr/>
        {userList.map((userObj) => {
          return (
            <div key={userObj.userId} className={classes.userContainer}>
                <Avatar src={userObj.userImageUrl} alt='user-image' style={{'display':'inline-block'}}/>
                <p style={{'display':'inline-block'}}>{userObj.userName}</p>
                <button style={{'display':'inline-block', 'backgroundColor':'#43afa4'}}
                  onClick={() => followUser(userObj.userId, userObj.userName)}>FOLLOW</button>
            </div>
          );
        })}

        { currentPageNum > 0 ? <a href='#' onClick={(eve) => {eve.preventDefault();
          getNextPageDetails(currentPageNum-1); }} >Prev</a> : null }

        <a href='#' onClick={(eve) => {eve.preventDefault();
          getNextPageDetails(currentPageNum+1);}}>Next</a>
    </div>
  );
}

export default browseUsers;
