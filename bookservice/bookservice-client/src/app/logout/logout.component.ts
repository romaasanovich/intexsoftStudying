import {Component, OnInit} from '@angular/core';
import {AuthenticationService} from '../login/authentication.service';
import {Router} from '@angular/router';

@Component({
    selector: 'app-logout',
    templateUrl: './logout.component.html',
    styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

    constructor(private router: Router, private authenticationService: AuthenticationService) {
    }

    ngOnInit() {
        this.authenticationService.logout().subscribe(() => {
            alert('You are logout!!!');
        });
    }
}

