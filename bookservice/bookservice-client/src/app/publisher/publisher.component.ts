import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Publisher} from '../entity/publisher.model';
import {PublisherService} from './publisher.service';

@Component({
    selector: 'app-publisher',
    templateUrl: './publisher.component.html',
    styleUrls: ['./publisher.component.css']
})
export class PublisherComponent implements OnInit {

    publishers: Publisher[];
    displayedColumns = ['id', 'name', 'delete'];


    constructor(private router: Router, private publisherService: PublisherService) {

    }

    ngOnInit() {
        this.publisherService.getPublishers()
            .subscribe(data => {
                this.publishers = data;
            });
    }

    deletePublisher(publisher: Publisher): void {
        this.publisherService.deletePublisher(publisher)
            .subscribe(data => {
                    this.publishers = this.publishers.filter(u => u !== publisher);
                },
                (error: Response) => {
                    if (error.status === 403) {
                        alert('You have no permissions !!!');
                    }
                });
    }
}
