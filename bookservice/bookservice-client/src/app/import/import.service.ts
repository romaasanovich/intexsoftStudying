import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppSettings} from '../../../app.settings';

@Injectable()
export class ImportService {

    constructor(private http: HttpClient) {
    }

    public import(type: string) {
        return this.http.post(`${AppSettings.URL}/import/${type}`, type);
    }
}
