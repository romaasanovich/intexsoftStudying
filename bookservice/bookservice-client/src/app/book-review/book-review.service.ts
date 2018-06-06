import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Review} from '../entity/review.model';
import {AppSettings} from '../../../app.settings';


const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class BookReviewService {

    constructor(private http: HttpClient) {
    }

    public getBookReviews(id) {
        return this.http.get<Review[]>(`${AppSettings.URL}/review/${id}`);
    }

    public addReview(review: Review) {
        return this.http.post(`${AppSettings.URL}/review/`, review);
    }

    public delReview(review: Review) {
        return this.http.delete(`${AppSettings.URL}/review/${review.id.toString()}`);
    }
}
