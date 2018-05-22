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

@NgModule({
  declarations: [
    AppComponent,
    BookComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [BookService, LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
