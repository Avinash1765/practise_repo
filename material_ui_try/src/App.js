import React, { Component } from 'react';
import NavBar from './Components/NavBar/NavBar';
import {connect} from 'react-redux';

import {Route, Switch} from 'react-router-dom';
import  ErrorHandler from './ErrorBoundary/ErrorBoundary';
import { Suspense, lazy } from 'react';

const UserProfileWrapper=lazy(() => import('./Containers/UserProfile/UserProfileWrapper'))
const UserFeed= lazy(() => import('./Containers/UserFeed/UserFeed'))

class App extends Component {
  render() {

    let finalComp= null;

    if(this.props.isAuth){

        finalComp= (
          <Suspense fallback={<div>Loading...</div>}>
          <Switch>
          <Route path='/UserProfile/:userId' render={(props) => <ErrorHandler>
                                                                <UserProfileWrapper {...props} />
                                                                  </ErrorHandler> } />
          <Route path='/' component={UserFeed} />
          </Switch>
          </Suspense>
        )
    }
    return (
      <div className="App">
          <NavBar />
          {this.props.isAuth ? finalComp : null}
      </div>
    );
  }
}

const mapStateToProps = (state) => {
    return {isAuth: state.user.isAuthenticated, userId: state.user.userId};
}
export default connect(mapStateToProps)(App);
