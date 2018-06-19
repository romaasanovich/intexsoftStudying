import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Author} from '../entity/author/author.model';
import {AppSettings} from '../../../app.settings';
import {AuthorPageModel} from '../entity/author/author.page.model';


const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class AuthorService {

    constructor(private http: HttpClient) {
    }

    public getAuthors(page, size) {
        return this.http.get<AuthorPageModel>(`${AppSettings.URL}/authors/${page}/${size}`);
    }

    public addAuthor(author) {
        return this.http.post(`${AppSettings.URL}/author`, author);
    }

    public deleteAuthor(author: Author) {
        return this.http.delete(`${AppSettings.URL}/author/${author.id.toString()}`);
    }
}
