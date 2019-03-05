import { observable, action } from 'mobx';

export default class LoginStateStore {
    @observable
    loginState = 'LOGOUT';

    @action
    changeLoginState = (state) => {
      this.loginState = state;
    }
}
