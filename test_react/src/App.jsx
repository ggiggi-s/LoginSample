import React from 'react';
import { observer, inject } from 'mobx-react';
import MainPage from './pages/Main/MainPage';
import LoginPage from './pages/Login/LoginPage';

function App(props) {
  const { pageState } = props;
  let page;
  switch (pageState) {
    case 'MAIN': page = <MainPage />; break;
    case 'LOGIN': page = <LoginPage />; break;
    default: page = <MainPage />; break;
  }
  return page;
}

export default inject(({ pageStateStore }) => ({
  pageState: pageStateStore.pageState,
}))(observer(App));
