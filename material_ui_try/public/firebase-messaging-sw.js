importScripts('https://www.gstatic.com/firebasejs/5.7.2/firebase-app.js');
importScripts('https://www.gstatic.com/firebasejs/5.7.2/firebase-messaging.js');

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

const messaging = firebase.messaging();

self.addEventListener('notificationclick', (event) => {
    console.log('notification clicked');
    if (event.action) {
        clients.openWindow(event.action);
    }
    event.notification.close();
});
