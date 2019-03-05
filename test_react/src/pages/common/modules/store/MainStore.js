import { observable } from 'mobx';
import MainRepository from '../repository/MainRepository';

class MainStore {
    title = 'Login Sample';

    @observable
    userID = 'test user';

    @observable
    content = 'test';

    constructor() {
      MainRepository.login().then((res) => {
        this.userID = res.data.userID;
        this.content = res.data.content;
      });
    }
}

export default MainStore;
