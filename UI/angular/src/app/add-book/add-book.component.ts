import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Book } from '../entity/book.model';
import {BookService} from '../book/book.service';

@Component({
  templateUrl: './add-book.component.html'
})
export class AddBookComponent {

  book: Book = new Book();

  constructor(private router: Router, private bookService: BookService) {

  }

  // createBook(): void {
  //   this.bookService.createBook(this.book)
  //     .subscribe( data => {
  //       alert("Book created successfully.");
  //     });
  //
  // };

}
