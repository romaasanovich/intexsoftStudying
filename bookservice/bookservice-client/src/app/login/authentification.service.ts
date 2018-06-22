import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {AppSettings} from '../../../app.settings';


@Injectable()
export class AuthentificationService {

    options = {
        headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
    };

    constructor(private http: HttpClient) {
    }

    public login(username, password) {
        const body = `username=${username}&password=${password}`;
        return this.http.post(`${AppSettings.URL}/login`, body, this.options);
    }

    public logout() {
        return this.http.get(`${AppSettings.URL}/logout`);
    }
}
