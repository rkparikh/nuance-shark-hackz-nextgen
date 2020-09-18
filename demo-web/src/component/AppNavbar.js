import React, { Component } from 'react';
import { Link, NavLink } from 'react-router-dom';
import { Nav, Navbar, NavbarBrand, NavbarText, NavbarToggler, NavItem } from 'reactstrap';

export default class AppNavbar extends Component {
    constructor(props) {
        super(props);
        this.state = { isOpen: false };
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        return <Navbar color="dark" dark expand="md">
            <NavbarBrand tag={Link} to={this.props.homeUrl}>Demo</NavbarBrand>
            <NavbarToggler onClick={this.toggle} />
            <Nav className="mr-auto" navbar>
                <NavItem>
                    <NavLink to={this.props.homeUrl}>{this.props.headerName}</NavLink>
                </NavItem>
            </Nav>
            <NavbarText>{this.props.data ? this.props.data.firstName : ""}</NavbarText>

        </Navbar>;
    }
}