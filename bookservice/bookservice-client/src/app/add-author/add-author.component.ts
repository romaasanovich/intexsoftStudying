import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {Author} from '../entity/author/author.model';
import {AuthorService} from '../author/author.service';

@Component({
    selector: 'app-add-author',
    templateUrl: './add-author.component.html',
    styleUrls: ['./add-author.component.css']
})
export class AddAuthorComponent {

    birthDay;
    author: Author = new Author();
    selDate: Date;

    constructor(private router: Router, private authorService: AuthorService) {
    }

    addAuthor(): void {
        this.author.birthDay = this.selDate.toLocaleDateString();
        this.authorService.addAuthor(this.author).subscribe(data => {
                alert('Author created successfully.');
            },
            (error: Response) => {
                if (error.status === 403) {
                    alert('You have no permissions !!!');
                }
            });
    }
}
