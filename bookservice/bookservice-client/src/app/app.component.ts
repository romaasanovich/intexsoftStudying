import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Params, Router} from '@angular/router';
import {UserService} from './registration/user.service';
import {MatDialog} from '@angular/material';
import {ActivationExpiredDialogComponent} from './activation-expired-dialog/activation-expired-dialog.component';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
    userId: string;
    activationToken: string;
    username: string;

    constructor(private route: ActivatedRoute, private router: Router, private userService: UserService, public dialog: MatDialog) {
    }

    ngOnInit(): void {
        this.route.queryParams.subscribe((params: Params) => {
            this.userId = params['userId'];
            this.activationToken = params['token'];
            this.username = params['username'];
            if (this.userId !== undefined && this.activationToken !== undefined) {
                this.userService.activateUser(this.userId, this.activationToken).subscribe(data => {
                    if (data === true) {
                        alert('Your account activated !!! Please log in.');
                    } else {
                        this.openDialog();
                    }
                });
            } else if (this.username !== undefined) {
                this.router.navigate(['restore/link'], {
                    queryParams: {username: this.username}
                });
            }

        });
    }

    openDialog(): void {
        const dialogRef = this.dialog.open(ActivationExpiredDialogComponent, {
            width: '550px',
            data: {name: this.userId}
        });
        dialogRef.afterClosed().subscribe(() => {
            this.userService.reactivate(this.userId).subscribe(() => {
                alert('Activation message send to your e-mail');
            });
        });
    }
}
