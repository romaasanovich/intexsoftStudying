import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {ForgotPassService} from './forgot-pass.service';

@Component({
    selector: 'app-forgot-pass',
    templateUrl: './forgot-pass.component.html',
    styleUrls: ['./forgot-pass.component.css']
})
export class ForgotPassComponent {

    activationCode: number;
    username: string;
    inputCode: number;
    newPassword: string;
    hide = true;

    constructor(private router: Router, private forgotPassService: ForgotPassService) {
    }

    sendCode() {
        this.forgotPassService.sendCode(this.username.toString()).subscribe(data => {
                this.activationCode = data;
                if (this.activationCode === -1) {
                    alert('Error. Try again!!!');
                } else {
                    alert('Activation code send to your e-mail');
                }
            },
            error => {
                alert('Error. Try again!!!');
            }
        );
    }

    restorePassword() {
        if (Number(this.inputCode) === this.activationCode) {
            this.forgotPassService.restorePass(this.newPassword, this.username).subscribe(() => {
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
