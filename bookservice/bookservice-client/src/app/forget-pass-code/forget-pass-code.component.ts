import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {ForgetPassService} from './forget-pass.service';

@Component({
    selector: 'app-forgot-pass',
    templateUrl: './forget-pass-code.component.html',
    styleUrls: ['./forget-pass-code.component.css']
})
export class ForgetPassCodeComponent {

    activationCode: number;
    username: string;
    inputCode: number;
    newPassword: string;
    hide = true;

    constructor(private router: Router, private forgetPassService: ForgetPassService) {
    }

    sendCode() {
        this.forgetPassService.sendCode(this.username.toString()).subscribe(data => {
                this.activationCode = data;
                if (this.activationCode === -1) {
                    alert('Error. Try again!!!');
                } else {
                    alert('Restore code send to your e-mail');
                }
            },
            error => {
                alert('Error. Try again!!!');
            }
        );
    }

    restorePassword() {
        if (Number(this.inputCode) === this.activationCode) {
            this.forgetPassService.restorePass(this.newPassword, this.username).subscribe(() => {
                    alert('Your password is restored!');
                },
                () => {
                    alert('Error with changing password!');
                });
        } else {
            alert('Wrong code!!!');
        }
    }
}
