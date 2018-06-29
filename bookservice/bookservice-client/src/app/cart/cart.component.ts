import {Component, OnInit} from '@angular/core';
import {AppSettings} from '../../../app.settings';
import {BookService} from '../book/book.service';
import {Router} from '@angular/router';
import {Cart} from '../entity/cart.model';
import {CartService} from './cart.service';
import {MatTableDataSource} from '@angular/material';
import {BookDetails} from '../entity/book/book.details.model';
import {OrderService} from '../order/order.service';

@Component({
    selector: 'app-cart',
    templateUrl: './cart.component.html',
    styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
    arrayBooks: BookDetails[] = [];
    books;
    displayedColumns = ['image', 'name', 'price', 'publisher', 'authors', 'rate', 'delete'];
    URL = AppSettings.API_URL;


    constructor(private router: Router, private bookService: BookService, private cart: Cart, private cartService: CartService, private orderService: OrderService) {

    }

    ngOnInit() {
        this.cart.bookIds.forEach(id => {
            this.bookService.getById(id).subscribe(data => {
                this.arrayBooks.push(data);
                this.books = new MatTableDataSource<BookDetails>(this.arrayBooks);
            });
        });
    }

    deleteBook(bookId) {
        this.cartService.deleteBookFromCart(bookId);
        this.arrayBooks = this.arrayBooks.filter(u => u.id !== bookId);
        this.books = new MatTableDataSource<BookDetails>(this.arrayBooks);
    }

    addOrder() {
        this.orderService.addOrder().subscribe(() => {
            alert('Your order is added!!!');
            this.cart.totalPrice = 0.0;
            this.cart.bookIds = [];
        }, error1 => {
            alert('Unauthorized!!! Please log in!!!');
        });
    }

    goToBookDetails(id) {
        this.router.navigate(['/bookDetail'], {
            queryParams: {bookId: id}
        });
    }

    goToReview(id) {
        this.router.navigate(['/reviews'], {
            queryParams: {bookId: id}
        });
    }
}
