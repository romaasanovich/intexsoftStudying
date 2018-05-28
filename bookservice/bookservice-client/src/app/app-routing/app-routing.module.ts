import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BookComponent} from '../book/book.component';
import {LoginComponent} from '../login/login.component';
import {PublisherComponent} from '../publisher/publisher.component';
import {AuthorComponent} from '../author/author.component';
import {AddPublisherComponent} from '../add-publisher/add-publisher.component';
import {AddAuthorComponent} from '../add-author/add-author.component';
import {AddBookComponent} from '../add-book/add-book.component';


const routes: Routes = [
    {path: 'books', component: BookComponent},
    {path: 'login', component: LoginComponent},
    {path: 'publishers', component: PublisherComponent},
    {path: 'authors', component: AuthorComponent},
    {path: 'publisher', component: AddPublisherComponent},
    {path: 'author', component: AddAuthorComponent},
    {path: 'book', component: AddBookComponent}
];

@NgModule({
    imports: [
        RouterModule.forRoot(routes)
    ],
    exports: [
        RouterModule
    ],
    declarations: []
})
export class AppRoutingModule {
}
