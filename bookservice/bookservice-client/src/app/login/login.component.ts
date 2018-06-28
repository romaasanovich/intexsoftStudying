import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthenticationService} from './authentication.service';
import {HttpErrorResponse} from '@angular/common/http';
import {ForgetPassService} from '../forget-pass-code/forget-pass.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    username = '';
    password = '';
    hide = true;

    constructor(private router: Router, private authenticationService: AuthenticationService, private forgetPassService: ForgetPassService) {
    }

    ngOnInit() {
    }

    login(username, password) {
        this.authenticationService.login(username, password).subscribe(() => {
                alert('You are login!!!');
            }, (error1: HttpErrorResponse) => {
                alert(error1.headers.get('error'));
            }
        );
    }

    goToRestorePass() {
        if (this.username !== '') {
            this.forgetPassService.sendLink(this.username).subscribe(() => {
                    alert('Instructions to restore password send to your e-mail');
                },
                error1 => alert('Username not found'));
        } else {
            alert('Input username');
        }
    }
}
