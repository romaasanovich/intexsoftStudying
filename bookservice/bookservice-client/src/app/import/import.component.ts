import {Component} from '@angular/core';
import {Router} from "@angular/router";
import {ImportService} from "./import.service";

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
            .subscribe(data => {
                alert('Import is OK.');
            });
    }
}
