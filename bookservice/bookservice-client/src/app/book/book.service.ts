import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

import {Book} from '../entity/book.model';


const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class BookService {

    constructor(private http: HttpClient) {
    }

    public getBooks() {
        return this.http.get<Book[]>('http://localhost:8080/bookservice/api/books');
    }


    public addBook(book: Book) {
        return this.http.post<Book>('http://localhost:8080/bookservice/api/book', book);
    }

    public deleteBook(book: Book) {
        return this.http.delete('http://localhost:8080/bookservice/api/book' + '/' + book.id.toString());
    }

}
