import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';
import { Provider } from 'react-redux';
import {createStore, applyMiddleware} from 'redux';
import reducer from './reducers/reducer';
import {BrowserRouter} from 'react-router-dom';
import thunk from 'redux-thunk';

const store= createStore(reducer, applyMiddleware(thunk));


ReactDOM.render( <BrowserRouter><Provider store={store}>
    <App />
  </Provider></BrowserRouter>, document.getElementById('root'));
registerServiceWorker();
