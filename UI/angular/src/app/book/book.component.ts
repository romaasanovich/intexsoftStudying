import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import {Book} from '../entity/book.model';
import {BookService} from './book.service';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styles: []
})
export class BookComponent implements OnInit {

  books: Book[];

  constructor(private router: Router, private bookService: BookService) {

  }

  ngOnInit() {
    this.bookService.getBooks()
      .subscribe( data => {
        this.books = data;
      });
  }
}
