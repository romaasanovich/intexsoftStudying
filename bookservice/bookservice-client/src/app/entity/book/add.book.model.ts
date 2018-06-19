import {Publisher} from '../publisher/publisher.model';
import {Author} from '../author/author.model';

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