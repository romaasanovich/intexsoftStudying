import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../registration/user.service';

@Component({
    selector: 'app-change-password',
    templateUrl: './change-password.component.html',
    styleUrls: ['./change-password.component.css']
})
export class ChangePasswordComponent {

    hide = true;
    newPassword;
    oldPassword;

    constructor(private router: Router, private userService: UserService) {
    }

    changePassword() {
        this.userService.changePassword(this.oldPassword, this.newPassword).subscribe(
            () => {
                alert('Your password is changed!');
            },
            () => {
                alert('You have an error, check input fields!');
            });
    }
}
