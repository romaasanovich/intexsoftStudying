import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {AppSettings} from '../../../app.settings';


@Injectable()
export class ForgotPassService {

    constructor(private http: HttpClient) {
    }

    public sendCode(username: string) {
        const params = new HttpParams()
            .set('username', username);
        return this.http.post<number>(`${AppSettings.API_URL}/user/password/restore/code`, params);
    }

    public restorePass(newPassword, username) {
        const params = new HttpParams()
            .set('password', newPassword)
            .set('username', username);
        return this.http.post(`${AppSettings.API_URL}/user/password/restore`, params);
    }

}
