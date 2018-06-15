import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Book} from '../entity/book.model';
import {AppSettings} from '../../../app.settings';
import {BookDetails} from '../entity/book.details.model';
import {AddBook} from '../entity/add.book.model';


const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class BookService {

    constructor(private http: HttpClient) {
    }

    public getBooks() {
        return this.http.get<Book[]>(`${AppSettings.URL}/books`);
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
