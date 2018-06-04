import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

import {Book} from '../entity/book.model';
import {BookService} from '../book/book.service';
import {AuthorService} from '../author/author.service';
import {PublisherService} from '../publisher/publisher.service';
import {Publisher} from '../entity/publisher.model';
import {Author} from '../entity/author.model';
import {FormControl} from '@angular/forms';

@Component({
    selector: 'app-add-book',
    styleUrls: ['./add-book.component.css'],
    templateUrl: './add-book.component.html'
})
export class AddBookComponent implements OnInit {

    book: Book = new Book();
    publishers: Publisher[];
    authors: Author[];
    authorsList = new FormControl();

    constructor(private router: Router, private bookService: BookService, private  authorService: AuthorService,
                private  publService: PublisherService) {
    }


    ngOnInit() {
        this.publService.getPublishers()
            .subscribe(data => {
                this.publishers = data;
            });
        this.authorService.getAuthors()
            .subscribe(data => {
                this.authors = data;
            });
    }

    addBook(): void {
        this.bookService.addBook(this.book)
            .subscribe(data => {
                alert('Book created successfully.');
            });
    }
}
