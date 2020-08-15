import axios from '../../axios/axiosinstance';
import {messaging} from './Firebase';

async function subscribeToNotifications(userId){
    let permissionStatus = await getUserPermission(userId);
    console.log(permissionStatus);
}

async function storeTokenInDB(userId,msgToken){

  try{
    let storeTokenResp= await axios.get('/store-token', {params: {'MSG_TOKEN': msgToken, 'USER_ID': userId}});
    console.log('store token response ', storeTokenResp);
  }catch(err){
    console.log('error while storing token to DB', err);
  }
}

async function getUserPermission(userId){
  console.log('userid is ', userId);
  let permissionGranted= false;

  try{
  if(Notification.permission !== 'granted') {
      await Notification.requestPermission();
  }

  if(localStorage.getItem('INSTANCE_TOKEN') !== null){
    console.log(localStorage.getItem('INSTANCE_TOKEN'));
    permissionGranted= true;
  }else{
    const msgToken=await messaging.getToken();
    console.log(msgToken);
    await storeTokenInDB(userId,msgToken);
    localStorage.setItem('INSTANCE_TOKEN', msgToken);
    permissionGranted= true;
  }

}catch(err){
  console.log('error occured ', err);
}
finally{
  return permissionGranted;
}
}


export {subscribeToNotifications};
