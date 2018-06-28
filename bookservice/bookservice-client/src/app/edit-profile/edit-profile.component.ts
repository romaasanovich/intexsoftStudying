import {Component, OnInit} from '@angular/core';
import {UserService} from '../registration/user.service';
import {Router} from '@angular/router';
import {User} from '../entity/user.model';

@Component({
    selector: 'app-edit-profile',
    templateUrl: './edit-profile.component.html',
    styleUrls: ['./edit-profile.component.css']
})
export class EditProfileComponent implements OnInit {

    user: User = new User();

    males: string[] = ['MALE', 'FEMALE'];
    selDate: Date;

    constructor(private router: Router, private userService: UserService) {
    }

    ngOnInit() {
        this.userService.getUser().subscribe(user => {
                this.user = user;
            },
            error => {
                alert('Please log in!!!');
            });
    }

    editUser() {
        this.user.birthday = this.selDate.toLocaleDateString();
        this.userService.editUser(this.user).subscribe(() => {
                alert('Your profile is edited!');
            },
            () => {
                alert('You have an error, check input fields!');
            });
    }

    goToChangePassword() {
        this.router.navigate(['/password']);
    }
}
