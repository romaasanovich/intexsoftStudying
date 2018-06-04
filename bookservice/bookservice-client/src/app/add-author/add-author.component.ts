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
    }

    addAuthor(): void {
        this.authorService.addAuthor(this.author).subscribe(data => {
            alert('Author created successfully.');
        });
    }
}
