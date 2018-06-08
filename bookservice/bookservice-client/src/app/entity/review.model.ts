import {Book} from './book.model';
import {User} from './user.model';

export class Review {
    id: number;
    rate: number;
    review: string;
    book: Book;
    username: string;
}
