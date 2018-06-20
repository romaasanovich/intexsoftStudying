import {Component, OnInit} from '@angular/core';
import {BookService} from '../book/book.service';
import {ActivatedRoute, Router} from '@angular/router';
import {BookReviewService} from './book-review.service';
import {MatTableDataSource, PageEvent} from '@angular/material';
import {Review} from '../entity/review/review.model';

@Component({
    selector: 'app-book-review',
    templateUrl: './book-review.component.html',
    styleUrls: ['./book-review.component.css']
})
export class BookReviewComponent implements OnInit {
    currentPage = 0;
    pageSize = 5;
    pageSizeOptions = [5, 10, 25];
    dataLength: number;
    reviews;
    selBookId: string;
    displayedColumns = ['user', 'review', 'rate'];


    constructor(private router: Router, private bookService: BookService, private bookReviewService: BookReviewService, private route: ActivatedRoute) {
    }

    ngOnInit() {
        this.selBookId = this.route.snapshot.queryParams.bookId;
        this.bookReviewService.getBookReviews(this.selBookId, this.currentPage, this.pageSize)
            .subscribe(data => {
                this.reviews = new MatTableDataSource<Review>(data.content);
                this.dataLength = data.totalElements;
            });
    }

    getReviews(event?: PageEvent) {
        this.bookReviewService.getBookReviews(this.selBookId, event.pageIndex, event.pageSize)
            .subscribe(data => {
                this.reviews = data.content;
                this.dataLength = data.totalElements;
            });
        return event;
    }

    goToAddReview() {
        this.router.navigate(['/add-review'], {
            queryParams: {bookId: this.selBookId}
        });
    }
}
