import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import '../App.css';
import AppNavbar from './AppNavbar';

class SystemRules extends Component {


  async componentDidMount() {
    const response = await fetch('/demo/patients/RQTKDTHUEWBNGLLWECUGHWSIN');
    const body = await response.json();
    alert(body);
  }


  render() {
    return (
      <div>
        <AppNavbar headerName="System Rules" homeUrl="/system-rules" />
        <Container fluid>
          <Button color="link"><Link to="/groups">Manage JUG Tour</Link></Button>
        </Container>
      </div>
    );
  }
}

export default SystemRules;