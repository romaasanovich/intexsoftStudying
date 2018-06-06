import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AppSettings} from '../../../app.settings';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class ImportService {

    constructor(private http: HttpClient) {
    }

    public import(type: string) {
        return this.http.post(`${AppSettings.URL}/import/${type}`, type);
    }
}
