import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { BookComponent } from './book/book.component';
import {AppRoutingModule} from './app-routing/app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';
import {BookService} from './book/book.service';
import { LoginComponent } from './login/login.component';
import {LoginService} from './login/login.service';
import { PublisherComponent } from './publisher/publisher.component';
import { AuthorComponent } from './author/author.component';
import {PublisherService} from './publisher/publisher.service';
import {AuthorService} from './author/author.service';
import { AddPublisherComponent } from './add-publisher/add-publisher.component';

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    LoginComponent,
    PublisherComponent,
    AuthorComponent,
    AddPublisherComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BookService, LoginService, PublisherService, AuthorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
