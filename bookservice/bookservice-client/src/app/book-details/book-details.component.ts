import {Component, OnInit} from '@angular/core';
import {BookService} from '../book/book.service';
import {ActivatedRoute, Router} from '@angular/router';
import {BookDetails} from '../entity/book/book.details.model';
import {AppSettings} from '../../../app.settings';
import {ImageService} from './image.service';

@Component({
    selector: 'app-book-details',
    templateUrl: './book-details.component.html',
    styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

    bookDetails: BookDetails = new BookDetails();
    books: BookDetails[] = [];
    displayedColumns = ['image', 'price', 'description', 'authors', 'publisher', 'publishDate', 'rate'];
    URL = AppSettings.URL;
    id = this.route.snapshot.queryParams.bookId;
    imageUrls: string[] = [];

    constructor(private router: Router, private bookService: BookService, private route: ActivatedRoute,
                private imageService: ImageService) {
    }

    ngOnInit() {
        this.bookService.getById(this.id).subscribe(data => {
            this.imageService.getImages(this.id).subscribe(images => {
                this.imageUrls = images;
                this.bookDetails = data;
                this.books = Array.of(this.bookDetails);
            });
        });
    }


    goToReview(id) {
        this.router.navigate(['/reviews'], {
            queryParams: {bookId: id}
        });
    }
}
