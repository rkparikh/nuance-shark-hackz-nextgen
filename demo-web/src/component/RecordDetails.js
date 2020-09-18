import React, { Component } from 'react';
import {
  Button, Col, Container, Dropdown, DropdownItem, DropdownMenu, DropdownToggle,
  Form, FormGroup, Input, Label, Modal, ModalBody, ModalHeader, Row, Table
} from 'reactstrap';
import '../App.css';
import AppNavbar from './AppNavbar';

class RecordDetails extends Component {

  constructor(props) {
    super(props);
    this.state = {
      dropdownOpen: false,
      dropDownValue: "--- Select ---",
      patientDetails: undefined,
      factorSid: -1,
      patientFactorData: [],
      modalOpen: false,
      pfRecord: {}
    };

    this.toggle = this.toggle.bind(this);
    this.loadPatientData = this.loadPatientData.bind(this);
    this.onFactorSelect = this.onFactorSelect.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    this.loadPatientData();
  }


  async loadPatientData() {
    const response = await fetch(`/demo/patient/detail/TEST_MRN1`);
    const body = await response.json();
    this.setState({ patientDetails: body });
  }

  toggle() {
    this.setState({
      dropdownOpen: !this.state.dropdownOpen
    });
  }

  toggleModal = () => {
    this.setState({
      modalOpen: !this.state.modalOpen
    });
  }


  onFactorSelect(e) {
    const elem = e.currentTarget;
    const dropDownValue = elem.textContent;
    const factorSid = elem.getAttribute("data-factor-sid");
    this.setState({ dropDownValue, factorSid })
    this.loadPatientFactorData(this.state.patientDetails.patientSid, factorSid);
  }

  async loadPatientFactorData(patientSid, factorSid) {
    const response = await fetch(`/demo/patient/factors/${patientSid}/${factorSid}`);
    const body = await response.json();
    this.setState({ patientFactorData: body });
  }

  handleChange(event) {
    const target = event.target;
    const value = target.value;
    const name = target.name;
    let pfRecord = { ...this.state.pfRecord };
    pfRecord[name] = value;
    this.setState({ pfRecord });
  }


  async handleSubmit(event) {
    event.preventDefault();
    const { pfRecord } = this.state;
    pfRecord.patientSid = this.state.patientDetails.patientSid;
    pfRecord.factorSid = this.state.factorSid;

    await fetch('/demo/patient/factor/save', {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(pfRecord),
    });
    this.loadPatientFactorData(this.state.patientDetails.patientSid, this.state.factorSid);
    this.toggleModal();
  }

  render() {
    return (
      <div>
        <AppNavbar headerName="Record Details" homeUrl="/" data={this.state.patientDetails} />
        <Container fluid>
          <div className="mt-2">
            <Row>
              <Col><Dropdown isOpen={this.state.dropdownOpen} toggle={this.toggle} size="sm">
                <DropdownToggle caret>
                  {this.state.dropDownValue}
                </DropdownToggle>
                <DropdownMenu>
                  <DropdownItem>
                    <div onClick={this.onFactorSelect} data-factor-sid="1">Blood Sugar Level</div>
                  </DropdownItem>
                </DropdownMenu>
              </Dropdown></Col>
              <Col>{this.renderAddForm()}</Col>
            </Row>
          </div>
          <div className="mt-2">
            {this.renderPatientFactorData()}
          </div>
        </Container>
      </div>
    );
  }

  renderPatientFactorData() {
    const { patientFactorData } = this.state;
    if (patientFactorData.length <= 0) {
      return;
    }
    return (
      <Table striped bordered size="sm">
        <thead>
          <tr>
            <th>#</th>
            <th>Record Date</th>
            <th>Value</th>
          </tr>
        </thead>
        <tbody>
          {this.renderEncounterData(patientFactorData)}
        </tbody>
      </Table>
    );
  }

  renderEncounterData(patientFactorData) {
    return [...patientFactorData].map((pf, index) => {
      return (
        <tr key={pf.patientFactorSid}>
          <th scope="row">{index + 1}</th>
          <td>{pf.recordEntryDate}</td>
          <td>{pf.recordValue}</td>
        </tr>
      );
    });
  }

  renderAddForm() {
    const { pfRecord } = this.state;
    return (
      <div>
        <Button size="sm" color="primary" onClick={this.toggleModal}>Add Record</Button>
        <Modal isOpen={this.state.modalOpen} toggle={this.toggleModal}>
          <ModalHeader toggle={this.toggleModal}>Add Record</ModalHeader>
          <ModalBody>
            <Form onSubmit={this.handleSubmit}>
              <FormGroup>
                <Label for="name">Name</Label>
                <Input type="text" name="recordValue" id="recordValue" value={pfRecord.recordValue || ''}
                  onChange={this.handleChange} />
              </FormGroup>
              <FormGroup>
                <Label for="address">Address</Label>
                <Input type="text" name="recordEntryDate" id="recordEntryDate" value={pfRecord.recordEntryDate || ''}
                  onChange={this.handleChange} />
              </FormGroup>
              <FormGroup>
                <Button color="primary" type="submit">Save</Button>{' '}
                <Button color="secondary" onClick={this.toggleModal}>Cancel</Button>
              </FormGroup>
            </Form>
          </ModalBody>
        </Modal>
      </div>
    );
  }
}

export default RecordDetails;