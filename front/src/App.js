import React, { Component } from 'react';
import './App.css';

import LoginPage from './Login/LoginPage';
import Main from './Main/Main';


class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      login: true
    };
  }

  handleChange(value){
    this.setState({ login: true});
  }

  render() {
    if (this.state.login === false) {
      return (
        <LoginPage handleChange={this.handleChange.bind(this)} />
      );
    } else {
      return (
        <Main/>
      )
    }
  }
}

export default App;