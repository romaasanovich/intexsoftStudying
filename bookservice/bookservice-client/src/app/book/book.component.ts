import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {Book} from '../entity/book.model';
import {BookService} from './book.service';
import {BookReviewService} from '../book-review/book-review.service';

@Component({
    selector: 'app-book',
    templateUrl: './book.component.html',
    styles: []
})
export class BookComponent implements OnInit {

    books: Book[] = [];
    displayedColumns = ['id', 'name'/*,'description'*/, 'price', 'publisher', 'delete', 'rate'];


    constructor(private router: Router, private bookService: BookService, private bookReview: BookReviewService) {

    }

    ngOnInit() {
        this.bookService.getBooks()
            .subscribe(data => {
                this.books = data;
                this.getRate(this.books);
            });
    }

    deleteBook(book: Book): void {
        this.bookService.deleteBook(book)
            .subscribe(data => {
                this.books = this.books.filter(u => u !== book);
            });
    }

    public getRate(books: Book[]) {
        books.forEach(book => {
            this.bookReview.getRate(book);
        });
    }

    goToReview(id) {
        this.router.navigate(['/reviews'], {
            queryParams: {bookId: id}
        });
    }
}
