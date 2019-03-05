import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import { Provider } from 'mobx-react';
import App from './App';
import * as serviceWorker from './serviceWorker';
import MainStore from './pages/common/modules/store/MainStore';
import LoginStateStore from './pages/common/modules/store/LoginStateStore';
import PageStateStore from './pages/common/modules/store/PageStateStore';

const mainStore = new MainStore();
const pageStateStore = new PageStateStore();
const loginStateStore = new LoginStateStore();

ReactDOM.render(
  <Provider
    mainStore={mainStore}
    pageStateStore={pageStateStore}
    loginStateStore={loginStateStore}
  >
    <App />
  </Provider>,
  document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: http://bit.ly/CRA-PWA
serviceWorker.unregister();
