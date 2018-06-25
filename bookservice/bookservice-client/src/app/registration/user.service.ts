import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppSettings} from '../../../app.settings';
import {User} from '../entity/user.model';

@Injectable()
export class UserService {

    constructor(private http: HttpClient) {
    }

    public saveUser(user: User) {
        return this.http.post(`${AppSettings.API_URL}/user`, user);
    }

    public getUser() {
        return this.http.get<User>(`${AppSettings.API_URL}/user`);
    }
}
