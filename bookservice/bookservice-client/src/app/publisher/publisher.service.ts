import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Publisher} from '../entity/publisher/publisher.model';
import {AppSettings} from '../../../app.settings';
import {PublisherPageModel} from '../entity/publisher/publisher.page.model';


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

    public getPublishers(page, size) {
        return this.http.get<PublisherPageModel>(`${AppSettings.URL}/publishers/${page}/${size}`);
    }

    public deletePublisher(publisher: Publisher) {
        return this.http.delete(`${AppSettings.URL}/publisher/${publisher.id.toString()}`);
    }

}
