import React, {useRef, useEffect} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Avatar from '@material-ui/core/Avatar';
import TextField from '@material-ui/core/TextField';
import AddAPhotoIcon from '@material-ui/icons/AddAPhoto';
import Button from '@material-ui/core/Button';

const createPostStyles= makeStyles({
      createPostContainer: {
        width: '100%',
        border: '1px solid rgba(0,0,0, 0.2)'
      },
      userInfoBar: {
        height: '4rem',
        paddingLeft: '0.8rem',
        backgroundColor: '#43afa4',
        display: 'flex',
        flexDirection: 'row',
        justifyContent: 'flex-start',
        alignItems:'center'
      },
      createPostInputContainer: {
        padding: '1.5rem'
      },
      createPostInput: {
        width: '92%'
      },
      submitPostBar: {
        height: '3rem',
        backgroundColor: '#43afa4',
        display: 'flex',
        justifyContent: 'flex-end'
      },
      submitPostButton:{
          backgroundColor: '#1d8b80',
          '& :hover':{
              background: '#1d8b80'
          }
      }
});

const createPost = ({userImageUrl, userName, submitPostMethod, isCreatingPost}) => {

    const refObj= useRef('');
    const classes= createPostStyles();

    useEffect(() => {
        refObj.current.value='';
    });
    
    return (
      <div className={classes.createPostContainer}>
        <div className={classes.userInfoBar}>
            <Avatar src={userImageUrl} alt="userImage" />
            <Typography variant="h6">{userName}</Typography>
        </div>
        <div className={classes.createPostInputContainer}>
              <TextField label="Add a status" variant="outlined" className={classes.createPostInput} inputRef={refObj}/><br />
              <AddAPhotoIcon style={{marginTop: '1rem'}}/>
        </div>
        <div className={classes.submitPostBar}>
            <Button className={classes.submitPostButton} onClick={() => submitPostMethod(refObj.current.value)}>{
              isCreatingPost ? 'SENDING' : 'POST'}</Button>
        </div>
    </div>
  );
}

export default React.memo(createPost);
