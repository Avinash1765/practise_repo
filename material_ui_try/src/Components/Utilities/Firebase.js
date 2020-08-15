import firebase from 'firebase/app';
import '@firebase/messaging';

const config = {
    apiKey: "AIzaSyDOfVo4XibzID1bEMNbRom5qM2khfPBXnc",
    authDomain: "nextconnect-1765.firebaseapp.com",
    databaseURL: "https://nextconnect-1765.firebaseio.com",
    projectId: "nextconnect-1765",
    storageBucket: "nextconnect-1765.appspot.com",
    messagingSenderId: "253377205079",
    appId: "1:253377205079:web:c62730d42dd2960aa4e412",
    measurementId: "G-1YFRFBVM8H"
  };

firebase.initializeApp(config);

console.log('firebase file loaded');
// initialize messaging
let messaging = firebase.messaging();
console.log(messaging);
messaging.onMessage((payload) => {
            console.log('yes triggered', payload);
            const title = payload.notification.title;
            const options = {
                body: payload.notification.body,
                icon: payload.notification.icon,
                actions: [
                    {
                        action: payload.fcmOptions.link,
                        title: 'Book Appointment'
                    }
                ]
            };
          //  registration.showNotification(title, options);
        });

export {
    messaging
};
