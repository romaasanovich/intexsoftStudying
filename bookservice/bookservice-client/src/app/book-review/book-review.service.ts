import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Review} from '../entity/review.model';


const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class BookReviewService {

    constructor(private http: HttpClient) {
    }

    public getBookReviews(id) {
        return this.http.get<Review[]>(`http://localhost:8080/bookservice/api/review/book/${id}`);
    }

    public addReview(review: Review) {
        return this.http.post(`http://localhost:8080/bookservice/api/review/`, review);
    }

    public delReview(review: Review) {
        return this.http.delete(`http://localhost:8080/bookservice/api/review/${review.id.toString()}`);
    }

    public getRate(book) {
        let sumRates = 0;
        let rate = 0.0;
        this.getBookReviews(book.id).subscribe(reviews => {
            if (reviews.length !== 0) {
                reviews.forEach(item => {
                    sumRates += item.rate;
                });
            }
            if (sumRates === 0.0) {
                rate = 0.0;
            } else {
                rate = (sumRates / reviews.length);
            }
            book.rate = rate;
        });
    }
}
