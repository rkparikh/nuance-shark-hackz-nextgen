import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import '../App.css';
import AppNavbar from './AppNavbar';

class Home extends Component {
  render() {
    return (
      <div>
        <AppNavbar/>
        <Container fluid>
          <Button color="link"><Link to="/groups">Manage JUG Tour</Link></Button>
        </Container>
      </div>
    );
  }
}

export default Home;