import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthentificationService} from './authentification.service';
import {AppComponent} from '../app.component';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    username = '';
    password = '';
    hide = true;

    constructor(private router: Router, private authentificationService: AuthentificationService) {
    }

    ngOnInit() {
    }

    login(username, password) {
        this.authentificationService.login(username, password).subscribe(() => {
            alert('You are login!!!');
        }, error => {
            alert('Wrong username or password. Try again!!!');
        });
    }
}
