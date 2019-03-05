import React, { Component } from 'react';
import {
  Navbar, Nav, Button,
} from 'react-bootstrap';
import { observer, inject } from 'mobx-react';
import Form from 'react-bootstrap/FormGroup';

@inject(({
  mainStore, loginStateStore, pageStateStore,
}) => ({
  mainStore, loginStateStore, pageStateStore,
}))
@observer
class CommonHeader extends Component {
  render() {
    const { title, userID } = this.props.mainStore;
    const { loginState, changeLoginState } = this.props.loginStateStore;
    const { changePageState } = this.props.pageStateStore;
    return (
      <Navbar bg="dark" variant="dark">
        <Navbar.Brand>{title}</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="mr-auto">
            <Nav.Link>Home</Nav.Link>
          </Nav>
          {loginState === 'LOGIN' ? (
            <Form inline>
              <div>
                Hello,&nbsp;
                {userID}
              </div>
              <Button variant="outline-danger" onClick={() => changeLoginState('LOGOUT')}>LOGOUT</Button>
            </Form>
          ) : (<Button variant="outline-success" onClick={() => changePageState('LOGIN')}>LOGIN</Button>)}
        </Navbar.Collapse>
      </Navbar>
    );
  }
}

export default CommonHeader;
