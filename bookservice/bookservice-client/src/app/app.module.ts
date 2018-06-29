import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {BookComponent} from './book/book.component';
import {AppRoutingModule} from './app-routing/app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {BookService} from './book/book.service';
import {PublisherComponent} from './publisher/publisher.component';
import {AuthorComponent} from './author/author.component';
import {PublisherService} from './publisher/publisher.service';
import {AuthorService} from './author/author.service';
import {AddPublisherComponent} from './add-publisher/add-publisher.component';
import {AddAuthorComponent} from './add-author/add-author.component';
import {AddBookComponent} from './add-book/add-book.component';
import {ImportComponent} from './import/import.component';
import {ImportService} from './import/import.service';
import {MatCardModule, MatDialogModule, MatIconModule, MatNativeDateModule, MatTableModule} from '@angular/material';
import {MatButtonModule} from '@angular/material/button';
import {MatInputModule} from '@angular/material/input';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatSelectModule} from '@angular/material/select';
import {FormsModule} from '@angular/forms';
import {BookReviewComponent} from './book-review/book-review.component';
import {BookReviewService} from './book-review/book-review.service';
import {AddReviewComponent} from './add-review/add-review.component';
import {BookDetailsComponent} from './book-details/book-details.component';
import {ImageService} from './book-details/image.service';
import {MatPaginatorModule} from '@angular/material/paginator';
import {LoginComponent} from './login/login.component';
import {AuthenticationService} from './login/authentication.service';
import {LogoutComponent} from './logout/logout.component';
import {RegistrationComponent} from './registration/registration.component';
import {UserService} from './registration/user.service';
import {EditProfileComponent} from './edit-profile/edit-profile.component';
import {ChangePasswordComponent} from './change-password/change-password.component';
import {ForgetPassCodeComponent} from './forget-pass-code/forget-pass-code.component';
import {ForgetPassService} from './forget-pass-code/forget-pass.service';
import {ForgetPassLinkComponent} from './forget-pass-link/forget-pass-link.component';
import {ActivationExpiredDialogComponent} from './activation-expired-dialog/activation-expired-dialog.component';
import {CartComponent} from './cart/cart.component';
import {Cart} from './entity/cart.model';
import {CartService} from './cart/cart.service';
import {OrderComponent} from './order/order.component';
import {OrderService} from './order/order.service';


@NgModule({
    declarations: [
        AppComponent,
        BookComponent,
        PublisherComponent,
        AuthorComponent,
        AddPublisherComponent,
        AddAuthorComponent,
        AddBookComponent,
        ImportComponent,
        BookReviewComponent,
        AddReviewComponent,
        BookDetailsComponent,
        LoginComponent,
        LogoutComponent,
        RegistrationComponent,
        EditProfileComponent,
        ChangePasswordComponent,
        ForgetPassCodeComponent,
        ForgetPassLinkComponent,
        ActivationExpiredDialogComponent,
        CartComponent,
        OrderComponent
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        MatTableModule,
        MatButtonModule,
        MatInputModule,
        MatIconModule,
        BrowserAnimationsModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatSelectModule,
        MatPaginatorModule,
        MatCardModule,
        MatDialogModule
    ],
    entryComponents: [
        ActivationExpiredDialogComponent
    ],
    providers: [BookService, PublisherService, AuthorService, ImportService, BookReviewService, ImageService, AuthenticationService, UserService, ForgetPassService, CartService, Cart, OrderService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
