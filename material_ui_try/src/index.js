import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import { Provider } from 'react-redux';
import {createStore, applyMiddleware, combineReducers} from 'redux';
import Reducer from './reducers/reducer';
import {BrowserRouter} from 'react-router-dom';
import thunk from 'redux-thunk';
import PostReducer from './reducers/postReducer';
import axios from './axios/axiosinstance';

axios.interceptors.request.use((request) => {
  request.headers['Authorization']= 'Basic dXNlcjE6dXNlcjFQYXNz';
  return request;
})

const store= createStore(combineReducers({user: Reducer, post: PostReducer}), applyMiddleware(thunk));


ReactDOM.render( <BrowserRouter><Provider store={store}>
    <App />
  </Provider></BrowserRouter>, document.getElementById('root'));
registerServiceWorker();
