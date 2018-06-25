import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {AppSettings} from '../../../app.settings';
import {User} from '../entity/user.model';

@Injectable()
export class UserService {

    constructor(private http: HttpClient) {
    }

    public addUser(user: User) {
        return this.http.post(`${AppSettings.API_URL}/user/register`, user);
    }

    public editUser(user: User) {
        return this.http.post(`${AppSettings.API_URL}/user/edit`, user);
    }

    public getUser() {
        return this.http.get<User>(`${AppSettings.API_URL}/user`);
    }

    public changePassword(oldPassword, newPassword) {
        const params = new HttpParams()
            .set('oldPassword', oldPassword)
            .set('newPassword', newPassword);
        return this.http.post(`${AppSettings.API_URL}/user/password`, params);
    }
}
