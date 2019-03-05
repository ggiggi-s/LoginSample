import React, { Component } from 'react';
import { observer, inject } from 'mobx-react';
import CommonHeader from '../../components/molecules/CommonHeader';

@inject(({ mainStore }) => ({ mainStore }))
@observer
class LoginPage extends Component {
  render() {
    const { title } = this.props.mainStore;
    return (
      <div>
        <CommonHeader />
        <br />
        <div style={{ textAlign: 'center' }} className="container">
          <h1>
            {title}
          </h1>
          <form>
            <div className="form-group">
              <label htmlFor="username">
                Username
                <input
                  type="text"
                  className="form-control"
                  id="username"
                  name="username"
                />
              </label>
            </div>
            <div className="form-group">
              <label htmlFor="password">
                Password
                <input
                  type="password"
                  className="form-control"
                  id="password"
                  name="password"
                />
              </label>
            </div>
            <button type="submit" className="btn btn-primary">Submit</button>
          </form>
        </div>
      </div>
    );
  }
}

export default LoginPage;
