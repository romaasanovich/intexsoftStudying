import {Component, OnInit} from '@angular/core';
import {BookService} from '../book/book.service';
import {ActivatedRoute, Router} from '@angular/router';
import {BookReviewService} from './book-review.service';
import {Review} from '../entity/review.model';
import {Book} from '../entity/book.model';

@Component({
    selector: 'app-book-review',
    templateUrl: './book-review.component.html',
    styleUrls: ['./book-review.component.css']
})
export class BookReviewComponent implements OnInit {
    reviews: Review[];
    selBookId: string;
    selBook: Book;
    displayedColumns = ['user', 'review', 'rate'];


    constructor(private router: Router, private bookService: BookService, private bookReviewService: BookReviewService, private route: ActivatedRoute) {
    }

    ngOnInit() {
        this.selBookId = this.route.snapshot.queryParams.bookId;
            this.bookReviewService.getBookReviews(this.selBookId)
                .subscribe(reviews => {
                    this.reviews = reviews;
                });
    }

    goToAddReview() {
        this.router.navigate(['/add-review'], {
            queryParams: {bookId: this.selBookId}
        });
    }
}
