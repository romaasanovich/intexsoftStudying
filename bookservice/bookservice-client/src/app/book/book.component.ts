import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {Book} from '../entity/book.model';
import {BookService} from './book.service';

@Component({
    selector: 'app-book',
    templateUrl: './book.component.html',
    styles: []
})
export class BookComponent implements OnInit {

    books: Book[];
    displayedColumns = ['id', 'name', 'description', 'price', 'publisher', 'publishDate', 'delete'];


    constructor(private router: Router, private bookService: BookService) {

    }

    ngOnInit() {
        this.bookService.getBooks()
            .subscribe(data => {
                this.books = data;
            });
    }

    deleteBook(book: Book): void {
        this.bookService.deleteBook(book)
            .subscribe(data => {
                this.books = this.books.filter(u => u !== book);
            });
    }
}
