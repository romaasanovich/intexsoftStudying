import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Book } from '../entity/book.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class BookService {

  constructor(private http: HttpClient) {}

  // public addBook() {
  //   return this.http.pos<Book[]>('http://localhost:8080/bookservice/api/books');
  // }


  public getBooks() {
    return this.http.get<Book[]>('http://localhost:8080/bookservice/api/books');
  }

}
