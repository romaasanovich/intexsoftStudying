import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {BookService} from '../book/book.service';
import {AuthorService} from '../author/author.service';
import {PublisherService} from '../publisher/publisher.service';
import {Publisher} from '../entity/publisher.model';
import {Author} from '../entity/author.model';
import {AddBook} from '../entity/add.book.model';

@Component({
    selector: 'app-add-book',
    styleUrls: ['./add-book.component.css'],
    templateUrl: './add-book.component.html'
})
export class AddBookComponent implements OnInit {

    book: AddBook = new AddBook();
    publishers: Publisher[];
    authors: Author[];
    selDate: Date;


    constructor(private router: Router, private bookService: BookService, private  authorService: AuthorService,
                private  publisherService: PublisherService) {
    }


    ngOnInit() {
        this.publisherService.getPublishers()
            .subscribe(data => {
                this.publishers = data;
            });
        this.authorService.getAuthors()
            .subscribe(data => {
                this.authors = data;
            });
    }

    addBook(): void {
        this.book.publishDate = this.selDate.toLocaleDateString();
        this.bookService.addBook(this.book)
            .subscribe(data => {
                    alert('Book created successfully.');
                },
                (error: Response) => {
                    if (error.status === 403) {
                        alert('You have no permissions !!!');
                    }
                });
    }
}
