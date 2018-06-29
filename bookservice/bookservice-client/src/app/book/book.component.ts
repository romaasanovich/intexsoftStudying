import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {Book} from '../entity/book/book.model';
import {BookService} from './book.service';
import {AppSettings} from '../../../app.settings';
import {MatTableDataSource, PageEvent} from '@angular/material';
import {CartService} from '../cart/cart.service';

@Component({
    selector: 'app-book',
    templateUrl: './book.component.html',
    styleUrls: ['./book.component.css']
})

export class BookComponent implements OnInit {

    currentPage = 0;
    pageSize = 5;
    pageSizeOptions = [5, 10, 25];
    books;
    dataLength: number;
    displayedColumns = ['image', 'name', 'price', 'publisher', 'authors', 'rate', 'delete', 'addToCart'];
    URL = AppSettings.API_URL;

    constructor(private router: Router, private bookService: BookService, private cartService: CartService) {

    }

    ngOnInit() {
        this.bookService.getBooks(this.currentPage, this.pageSize)
            .subscribe(data => {
                this.books = new MatTableDataSource<Book>(data.content);
                this.dataLength = data.totalElements;
            });
    }

    deleteBook(book: Book): void {
        this.bookService.deleteBook(book)
            .subscribe(() => {
                    this.books = this.books.filter(u => u !== book);
                    this.dataLength -= 1;
                },
                (error: Response) => {
                    if (error.status === 401) {
                        alert('Please log in!!!');
                    } else if (error.status === 403) {
                        alert('You have no permissions !!!');
                    }
                });
    }

    addBookToCart(bookId) {
        this.cartService.addBookToCart(bookId);
    }

    getBooks(event?: PageEvent) {
        this.bookService.getBooks(event.pageIndex, event.pageSize)
            .subscribe(data => {
                this.books = data.content;
                this.dataLength = data.totalElements;
            });
        return event;
    }

    goToBookDetails(id) {
        this.router.navigate(['/bookDetail'], {
            queryParams: {bookId: id}
        });
    }

    goToReview(id) {
        this.router.navigate(['/reviews'], {
            queryParams: {bookId: id}
        });
    }
}
