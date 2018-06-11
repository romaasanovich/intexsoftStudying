import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {ImportService} from './import.service';

@Component({
    selector: 'app-import',
    templateUrl: './import.component.html',
    styleUrls: ['./import.component.css']
})
export class ImportComponent {

    typeImport: string[] = ['xml', 'json'];
    selImport: string;

    constructor(private router: Router, private importService: ImportService) {
    }

    import(): void {
        this.importService.import(this.selImport)
            .subscribe(
                data => {
                    alert('Import is OK.');
                },
                (error: Response) => {
                    if (error.status === 404) {
                        alert('Import is already running!!!');
                    }
                    if (error.status === 500) {
                        alert('Import is have an error!!!');
                    }
                    if (error.status === 403) {
                        alert('You have no permissions !!!');
                    }
                });
    }
}
