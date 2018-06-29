import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {BookComponent} from '../book/book.component';
import {PublisherComponent} from '../publisher/publisher.component';
import {AuthorComponent} from '../author/author.component';
import {AddPublisherComponent} from '../add-publisher/add-publisher.component';
import {AddAuthorComponent} from '../add-author/add-author.component';
import {AddBookComponent} from '../add-book/add-book.component';
import {ImportComponent} from '../import/import.component';
import {BookReviewComponent} from '../book-review/book-review.component';
import {AddReviewComponent} from '../add-review/add-review.component';
import {BookDetailsComponent} from '../book-details/book-details.component';
import {LoginComponent} from '../login/login.component';
import {LogoutComponent} from '../logout/logout.component';
import {RegistrationComponent} from '../registration/registration.component';
import {EditProfileComponent} from '../edit-profile/edit-profile.component';
import {ChangePasswordComponent} from '../change-password/change-password.component';
import {ForgetPassCodeComponent} from '../forget-pass-code/forget-pass-code.component';
import {ForgetPassLinkComponent} from '../forget-pass-link/forget-pass-link.component';
import {CartComponent} from '../cart/cart.component';


const routes: Routes = [
    {path: 'books', component: BookComponent},
    {path: 'publishers', component: PublisherComponent},
    {path: 'authors', component: AuthorComponent},
    {path: 'publisher', component: AddPublisherComponent},
    {path: 'author', component: AddAuthorComponent},
    {path: 'book', component: AddBookComponent},
    {path: 'import', component: ImportComponent},
    {path: 'reviews', component: BookReviewComponent},
    {path: 'add-review', component: AddReviewComponent},
    {path: 'bookDetail', component: BookDetailsComponent},
    {path: 'login', component: LoginComponent},
    {path: 'logout', component: LogoutComponent},
    {path: 'registration', component: RegistrationComponent},
    {path: 'edit', component: EditProfileComponent},
    {path: 'password', component: ChangePasswordComponent},
    {path: 'restore/code', component: ForgetPassCodeComponent},
    {path: 'restore/link', component: ForgetPassLinkComponent},
    {path: 'cart', component: CartComponent}

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
