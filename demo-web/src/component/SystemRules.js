import React, { Component } from 'react';
import { Container, Table } from 'reactstrap';
import '../App.css';
import AppNavbar from './AppNavbar';

class SystemRules extends Component {

  constructor(props) {
    super(props);
    this.state = {
      rulesData: []
    };

  }

  async componentDidMount() {
    const response = await fetch('/demo/system-rules');
    const rulesData = await response.json();
    this.setState({ rulesData });
  }


  render() {
    return (
      <div>
        <AppNavbar headerName="System Rules" homeUrl="/system-rules" />
        <Container fluid>
          <div className="mt-2">
            {this.renderSystemRulesTable()}
          </div>
        </Container>
      </div>
    );
  }


  renderSystemRulesTable() {
    const { rulesData } = this.state;
    if (rulesData.length <= 0) {
      return;
    }
    return (
      <Table striped bordered size="sm">
        <thead>
          <tr>
            <th>#</th>
            <th>Name</th>
            <th>Description</th>
            <th>Risk</th>
            <th>Rule Definition</th>
          </tr>
        </thead>
        <tbody>
          {this.renderSystemRulesData(rulesData)}
        </tbody>
      </Table>
    );
  }

  renderSystemRulesData(rulesData) {
    return [...rulesData].map((r, index) => {
      return (
        <tr key={r.vitalsRuleSid}>
          <th scope="row">{index + 1}</th>
          <td>{r.name}</td>
          <td>{r.description}</td>
          <td>{r.riskLevel}</td>
          <td>{r.definition}</td>
        </tr>
      );
    });
  }


}

export default SystemRules;