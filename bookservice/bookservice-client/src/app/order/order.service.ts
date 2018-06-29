import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppSettings} from '../../../app.settings';
import {Cart} from '../entity/cart.model';
import {Order} from '../entity/order.model';

@Injectable()
export class OrderService {
    private order: Order;

    constructor(private http: HttpClient, private  cart: Cart) {
    }

    public addOrder() {
        this.order = new Order();
        this.order.bookIds = this.cart.bookIds;
        this.order.totalPrice = this.cart.totalPrice;
        return this.http.post(`${AppSettings.API_URL}/order`, this.order);
    }
}
