import React, { Component } from 'react';
import NavBar from './Components/NavBar/NavBar';
import {connect} from 'react-redux';
import UserFeed from './Containers/UserFeed/UserFeed';
import UserProfileWrapper from './Containers/UserProfile/UserProfileWrapper';
import {Route, Switch} from 'react-router-dom';
import  ErrorHandler from './ErrorBoundary/ErrorBoundary';
class App extends Component {
  render() {

    let finalComp= null;

    if(this.props.isAuth){
        finalComp= (
          <Switch>
              <Route path='/UserProfile/:userId' render={(props) => <ErrorHandler>
                                                                <UserProfileWrapper {...props} />
                                                                  </ErrorHandler> } />
              <Route path='/' component={UserFeed} />
          </Switch>
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
    return {isAuth: state.isAuthenticated, userId: state.userId};
}
export default connect(mapStateToProps)(App);
