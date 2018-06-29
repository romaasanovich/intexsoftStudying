import {Injectable} from '@angular/core';
import {Cart} from '../entity/cart.model';
import {BookService} from '../book/book.service';


@Injectable()
export class CartService {

    constructor(private bookService: BookService, private cart: Cart) {
    }

    deleteBookFromCart(id) {
        this.cart.bookIds = this.cart.bookIds.filter(u => u !== id);
        this.bookService.getById(id).subscribe(data => {
            this.cart.totalPrice -= data.price;
        });
    }

    addBookToCart(id) {
        this.cart.bookIds.push(id);
        this.bookService.getById(id).subscribe(data => {
            this.cart.totalPrice += data.price;
        });
    }
}
