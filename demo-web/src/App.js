import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import './App.css';
import RecordDetails from './component/RecordDetails';
import SystemRules from './component/SystemRules'


class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={RecordDetails}/>
          <Route path='/system-rules' exact={true} component={SystemRules}/>
        </Switch>
      </Router>
    )
  }
}

export default App;