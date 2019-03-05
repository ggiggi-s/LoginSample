import axios from 'axios';

class MainRepository {
    URL = 'http://localhost:8080/resource';

    login() {
      return axios.get(this.URL);
    }
}

export default new MainRepository();
