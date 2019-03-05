import { observable, action } from 'mobx';

export default class PageStateStore {
    @observable
    pageState = 'MAIN';

    @action
    changePageState = (state) => {
      this.pageState = state;
    }
}
