import {Injectable} from '@angular/core';

@Injectable()
export class Cart {
    bookIds = [];
    totalPrice = 0.0;
}