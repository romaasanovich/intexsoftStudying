import { Component, OnInit } from '@angular/core';
import {Publisher} from '../entity/publisher.model';
import {Router} from '@angular/router';
import {PublisherService} from '../publisher/publisher.service';

@Component({
  selector: 'app-add-publisher',
  templateUrl: './add-publisher.component.html',
  styleUrls: ['./add-publisher.component.css']
})
export class AddPublisherComponent  {

  publisher: Publisher = new Publisher();

  constructor(private router: Router, private publisherService: PublisherService) {

  }

  addPublisher(): void  {
    this.publisherService.addPubl(this.publisher).subscribe( data => {
      alert('User created successfully.');
    });
}


}
