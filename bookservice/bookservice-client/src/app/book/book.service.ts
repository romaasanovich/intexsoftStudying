import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Book} from '../entity/book/book.model';
import {AppSettings} from '../../../app.settings';
import {BookDetails} from '../entity/book/book.details.model';
import {AddBook} from '../entity/book/add.book.model';
import {BookPageModel} from '../entity/book/book.page.model';


const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class BookService {

    constructor(private http: HttpClient) {
    }

    public getBooks(page, size) {
        return this.http.get<BookPageModel>(`${AppSettings.URL}/books/${page}/${size}`);
    }

    public addBook(book: AddBook) {
        return this.http.post<BookDetails>(`${AppSettings.URL}/book`, book);
    }

    public deleteBook(book: Book) {
        return this.http.delete(`${AppSettings.URL}/book/${book.id.toString()}`);
    }

    public getById(id: string) {
        return this.http.get<BookDetails>(`${AppSettings.URL}/books/${id}`);
    }
}
