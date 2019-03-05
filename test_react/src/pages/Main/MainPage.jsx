import React, { Component } from 'react';
import { observer, inject } from 'mobx-react';
import CommonHeader from '../../components/molecules/CommonHeader';

@inject(({ mainStore, loginStateStore }) => ({ mainStore, loginStateStore }))
@observer
class MainPage extends Component {
  render() {
    const { title, userID, content } = this.props.mainStore;
    const { loginState } = this.props.loginStateStore;
    return (
      <div>
        <CommonHeader />
        <br />
        <div style={{ textAlign: 'center' }} className="container">
          <h1>
            {title}
          </h1>
          <br />
          {
            loginState === 'LOGIN'
              ? (
                <div className="container">
                  <p>
                    Id:&nbsp;
                    <span>{userID}</span>
                  </p>
                  <p>
                    Message:&nbsp;
                    <span>{content}</span>
                  </p>
                </div>
              )
              : (<div>Hello, World !</div>)
          }
        </div>
      </div>
    );
  }
}

export default MainPage;
