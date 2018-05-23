import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {BookComponent} from '../book/book.component';
import {LoginComponent} from '../login/login.component';
import {PublisherComponent} from '../publisher/publisher.component';
import {AuthorComponent} from '../author/author.component';
import {AddPublisherComponent} from '../add-publisher/add-publisher.component';


const routes: Routes = [
  { path: 'books', component: BookComponent},
   { path: 'login', component: LoginComponent},
    {path: 'publishers', component : PublisherComponent},
      {path: 'authors', component : AuthorComponent},
        {path: 'publisher', component : AddPublisherComponent}
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
export class AppRoutingModule { }
