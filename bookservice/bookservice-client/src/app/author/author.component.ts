import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Author} from '../entity/author.model';
import {AuthorService} from './author.service';

@Component({
    selector: 'app-author',
    templateUrl: './author.component.html',
    styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

    authors: Author[];
    displayedColumns = ['id', 'name', 'bio', 'birthDay', 'delete'];

    constructor(private router: Router, private authorService: AuthorService) {

    }

    ngOnInit() {
        this.authorService.getAuthors()
            .subscribe(data => {
                this.authors = data;
            });

    }

    deleteAuthor(author: Author): void {
        this.authorService.deleteAuthor(author)
            .subscribe(data => {
                this.authors = this.authors.filter(u => u !== author);
            });
    }
}
