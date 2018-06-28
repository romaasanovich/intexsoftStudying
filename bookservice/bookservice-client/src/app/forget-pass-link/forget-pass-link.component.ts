import {Component} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {ForgetPassService} from '../forget-pass-code/forget-pass.service';

@Component({
    selector: 'app-forget-pass-link',
    templateUrl: './forget-pass-link.component.html',
    styleUrls: ['./forget-pass-link.component.css']
})
export class ForgetPassLinkComponent {

    username = this.route.snapshot.queryParams.username;
    newPassword: string;
    secondNewPass: string;
    hide = true;

    constructor(private router: Router, private forgetPassService: ForgetPassService, private route: ActivatedRoute) {
    }

    restorePassword() {
        if (this.newPassword === this.secondNewPass) {
            this.forgetPassService.restorePass(this.newPassword, this.username).subscribe(() => {
                    alert('Your password is restored!');
                },
                () => {
                    alert('Error with changing password!');
                });
        } else {
            alert('Passwords mismatch!!!');
        }
    }
}
