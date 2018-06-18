import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {Book} from '../entity/book.model';
import {BookService} from './book.service';
import {AppSettings} from '../../../app.settings';
import {ImageService} from '../book-details/image.service';

@Component({
    selector: 'app-book',
    templateUrl: './book.component.html',
    styleUrls: ['./book.component.css']
})

export class BookComponent implements OnInit {

    books: Book[] = [];
    displayedColumns = ['image', 'name', 'price', 'publisher', 'authors', 'rate', 'delete'];
    URL = AppSettings.URL;


    constructor(private router: Router, private bookService: BookService, private imageService: ImageService) {

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
                },
                (error: Response) => {
                    if (error.status === 403) {
                        alert('You have no permissions !!!');
                    }
                });
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
