import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Author} from '../entity/author.model';
import {AuthorService} from '../author/author.service';

@Component({
    selector: 'app-add-author',
    templateUrl: './add-author.component.html',
    styleUrls: ['./add-author.component.css']
})
export class AddAuthorComponent {

    birthDay;
    author: Author = new Author();

    constructor(private router: Router, private authorService: AuthorService) {
        this.birthDay = new Date().toISOString().substring(0, 10);
    }

    addAuthor(): void {
        this.author.birthDay = this.birthDay;
        this.authorService.addAuthor(this.author).subscribe(data => {
            alert('Author created successfully.');
        });
    }
}
