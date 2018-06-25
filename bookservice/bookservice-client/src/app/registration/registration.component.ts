import {Component} from '@angular/core';
import {User} from '../entity/user.model';
import {Router} from '@angular/router';
import {UserService} from './user.service';

@Component({
    selector: 'app-registration',
    templateUrl: './registration.component.html',
    styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {

    males: string[] = ['MALE', 'FEMALE'];
    selDate: Date;
    user: User = new User();
    hide = true;

    constructor(private router: Router, private userService: UserService) {
    }

    addUser() {
        this.user.birthday = this.selDate.toLocaleDateString();
        this.userService.saveUser(this.user).subscribe(() => {
                alert('Your profile are registered! Please log in!');
            },
            error => alert('You have an error, check input fields!'));
    }


}
