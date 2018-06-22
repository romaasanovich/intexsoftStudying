import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

import {Author} from '../entity/author/author.model';
import {AppSettings} from '../../../app.settings';
import {AuthorPageModel} from '../entity/author/author.page.model';


@Injectable()
export class AuthorService {

    constructor(private http: HttpClient) {
    }

    public getAuthors(page, size) {
        const params = new HttpParams()
            .set('page', page)
            .set('size', size);
        return this.http.get<AuthorPageModel>(`${AppSettings.API_URL}/authors`, {params});
    }

    public addAuthor(author) {
        return this.http.post(`${AppSettings.API_URL}/author`, author);
    }

    public deleteAuthor(author: Author) {
        return this.http.delete(`${AppSettings.API_URL}/author/${author.id.toString()}`);
    }
}
