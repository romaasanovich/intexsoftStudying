import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Publisher} from '../entity/publisher/publisher.model';
import {PublisherService} from './publisher.service';
import {PageEvent} from '@angular/material';

@Component({
    selector: 'app-publisher',
    templateUrl: './publisher.component.html',
    styleUrls: ['./publisher.component.css']
})
export class PublisherComponent implements OnInit {

    currentPage = 0;
    pageSize = 5;
    pageSizeOptions = [5, 10, 25];
    dataLength: number;
    publishers;
    displayedColumns = ['id', 'name', 'delete'];

    constructor(private router: Router, private publisherService: PublisherService) {

    }

    ngOnInit() {
        this.publisherService.getPublishers(this.currentPage, this.pageSize - 1)
            .subscribe(data => {
                this.publishers = data.content;
                this.dataLength = data.totalElements;

            });
    }

    deletePublisher(publisher: Publisher): void {
        this.publisherService.deletePublisher(publisher)
            .subscribe(data => {
                    this.publishers = this.publishers.filter(u => u !== publisher);
                    this.dataLength -= 1;
                },
                (error: Response) => {
                    if (error.status === 403) {
                        alert('You have no permissions !!!');
                    }
                });
    }

    getPublishers(event?: PageEvent) {
        this.publisherService.getPublishers(event.pageIndex, event.pageSize)
            .subscribe(data => {
                this.publishers = data.content;
                this.dataLength = data.totalElements;
            });
        return event;
    }
}
