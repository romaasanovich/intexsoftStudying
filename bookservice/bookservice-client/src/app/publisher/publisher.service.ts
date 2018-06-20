import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

import {Publisher} from '../entity/publisher/publisher.model';
import {AppSettings} from '../../../app.settings';
import {PublisherPageModel} from '../entity/publisher/publisher.page.model';

@Injectable()
export class PublisherService {

    constructor(private http: HttpClient) {
    }

    public getPublishers(page, size) {
        const params = new HttpParams()
            .set('page', page)
            .set('size', size);
        return this.http.get<PublisherPageModel>(`${AppSettings.URL}/publishers/`, {params});
    }

    public addPublisher(publisher) {
        return this.http.post(`${AppSettings.URL}/publisher`, publisher);
    }

    public deletePublisher(publisher: Publisher) {
        return this.http.delete(`${AppSettings.URL}/publisher/${publisher.id.toString()}`);
    }

}
