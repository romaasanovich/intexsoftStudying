import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {Book} from '../entity/book.model';
import {BookService} from './book.service';
import {BookReviewService} from '../book-review/book-review.service';

@Component({
    selector: 'app-book',
    templateUrl: './book.component.html',
    styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

    books: Book[] = [];
    displayedColumns = ['id', 'name', 'description', 'price', 'publisher', 'authors', 'rate', 'delete'];


    constructor(private router: Router, private bookService: BookService, private bookReview: BookReviewService) {

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

    goToReview(id) {
        this.router.navigate(['/reviews'], {
            queryParams: {bookId: id}
        });
    }
}
