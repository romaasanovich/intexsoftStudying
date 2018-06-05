import {Publisher} from './publisher.model';
import {Author} from './author.model';

export class Book {
    id: number;
    name: string;
    description: string;
    price: number;
    publishDate: Date;
    publisher: Publisher;
    authors: Author[];
    rate: number;
}
