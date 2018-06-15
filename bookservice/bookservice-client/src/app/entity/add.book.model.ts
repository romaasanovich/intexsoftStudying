import {Publisher} from './publisher.model';
import {Author} from './author.model';

export class AddBook {
    id: number;
    name: string;
    description: string;
    price: number;
    publishDate: string;
    publisher: Publisher;
    authors: Author[];
    rate: number;
}