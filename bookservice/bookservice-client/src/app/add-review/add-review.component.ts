import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {BookReviewService} from '../book-review/book-review.service';
import {Review} from '../entity/review/review.model';
import {Book} from '../entity/book/book.model';

@Component({
    selector: 'app-add-review',
    templateUrl: './add-review.component.html',
    styleUrls: ['./add-review.component.css']
})
export class AddReviewComponent {

    rates: number[] = [1, 2, 3, 4, 5];
    review: Review = new Review();

    constructor(private router: Router, private bookRevService: BookReviewService, private route: ActivatedRoute) {
        this.review.book = new Book();
    }

    addReview() {
        this.review.book.id = this.route.snapshot.queryParams.bookId;
        this.bookRevService.addReview(this.review).subscribe(data => {
                alert('Review created successfully!!!');
            },
            error => {
                alert('Unauthorized!!! Please log in!!!');
            });
    }

}
