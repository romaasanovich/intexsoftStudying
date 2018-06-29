import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

import {Book} from '../entity/book/book.model';
import {AppSettings} from '../../../app.settings';
import {BookDetails} from '../entity/book/book.details.model';
import {AddBook} from '../entity/book/add.book.model';
import {BookPageModel} from '../entity/book/book.page.model';


@Injectable()
export class BookService {

    constructor(private http: HttpClient) {
    }

    public getBooks(page, size) {
        const params = new HttpParams()
            .set('page', page)
            .set('size', size);
        return this.http.get<BookPageModel>(`${AppSettings.API_URL}/books`, {params});
    }

    public addBook(book: AddBook) {
        return this.http.post<BookDetails>(`${AppSettings.API_URL}/book`, book);
    }

    public deleteBook(book: Book) {
        return this.http.delete(`${AppSettings.API_URL}/book/${book.id.toString()}`);
    }

    public getById(id: string) {
        return this.http.get<BookDetails>(`${AppSettings.API_URL}/books/${id}`);
    }

}
