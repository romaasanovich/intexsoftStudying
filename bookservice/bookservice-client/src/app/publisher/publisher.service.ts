import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Publisher} from '../entity/publisher.model';
import {AppSettings} from '../../../app.settings';


const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class PublisherService {

    constructor(private http: HttpClient) {
    }


    public addPubl(publisher) {
        return this.http.post(`${AppSettings.URL}/publisher`, publisher);
    }

    public getPublishers() {
        return this.http.get<Publisher[]>(`${AppSettings.URL}/publishers`);
    }

    public deletePublisher(publisher: Publisher) {
        return this.http.delete(`${AppSettings.URL}/publisher/${publisher.id.toString()}`);
    }

}
