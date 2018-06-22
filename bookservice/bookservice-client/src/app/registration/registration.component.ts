import {Component, OnInit} from '@angular/core';
import {User} from '../entity/user.model';

@Component({
    selector: 'app-registration',
    templateUrl: './registration.component.html',
    styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

    males: string[] = ['MALE', 'FEMALE'];
    selDate: Date;
    user: User = new User();

    constructor() {
    }

    ngOnInit() {
    }

}
