import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Author} from '../entity/author/author.model';
import {AuthorService} from './author.service';
import {MatTableDataSource, PageEvent} from '@angular/material';

@Component({
    selector: 'app-author',
    templateUrl: './author.component.html',
    styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

    currentPage = 0;
    pageSize = 5;
    pageSizeOptions = [5, 10, 25];
    authors;
    dataLength: number;
    displayedColumns = ['id', 'name', 'bio', 'birthDay', 'delete'];

    constructor(private router: Router, private authorService: AuthorService) {

    }

    ngOnInit() {
        this.authorService.getAuthors(this.currentPage, this.pageSize)
            .subscribe(data => {
                this.authors = new MatTableDataSource<Author>(data.content);
                this.dataLength = data.totalElements;
            });

    }

    deleteAuthor(author: Author): void {
        this.authorService.deleteAuthor(author)
            .subscribe(data => {
                    this.authors = this.authors.filter(u => u !== author);
                    this.dataLength -= 1;

                },
                (error: Response) => {
                    if (error.status === 401) {
                        alert('Please log in!!!');
                    } else if (error.status === 403) {
                        alert('You have no permissions !!!');
                    }
                });
    }

    getAuthors(event?: PageEvent) {
        this.authorService.getAuthors(event.pageIndex, event.pageSize)
            .subscribe(data => {
                this.authors = data.content;
                this.dataLength = data.totalElements;
            });
        return event;
    }
}
