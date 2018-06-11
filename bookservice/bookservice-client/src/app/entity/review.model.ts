import {Book} from './book.model';

export class Review {
    id: number;
    rate: number;
    review: string;
    book: Book;
    username: string;
}
