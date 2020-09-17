import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import { Navbar, NavbarBrand, Button } from 'reactstrap';

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
            <NavbarBrand tag={Link} to="/">Home</NavbarBrand>
            <Button color="link"><Link to="/groups">Manage JUG Tour</Link></Button>
            <Button color="link"><Link to="/rules">Manage Rules</Link></Button>
        </Navbar>;
    }
}