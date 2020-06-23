import React from 'react';

class ErrorHandler extends React.Component {

    constructor(){
      super();
      this.state= {
        error:null, errorInfo:null
      }
    }

    componentDidCatch = (error, errorInfo) => {
          console.log('reached in error handler');
          console.log(error);
          this.setState({error: error, errorInfo: errorInfo});
    }

    render(){
      if(this.state.error){
        return (
           <h1>oops, unexpected error</h1>
            );
    }else {
        return this.props.children;
    }
    }
}

export default ErrorHandler;
