import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Author} from '../entity/author.model';
import {AppSettings} from '../../../app.settings';


const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class AuthorService {

    constructor(private http: HttpClient) {
    }

    public getAuthors() {
        return this.http.get<Author[]>(`${AppSettings.URL}/authors`);
    }

    public addAuthor(author) {
        return this.http.post(`${AppSettings.URL}/author`, author);
    }

    public deleteAuthor(author: Author) {
        return this.http.delete(`${AppSettings.URL}/author/${author.id.toString()}`);
    }
}
