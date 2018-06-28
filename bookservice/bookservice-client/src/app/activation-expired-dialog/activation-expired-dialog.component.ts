import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {UserService} from '../registration/user.service';


export interface DialogData {
    userId: string;
}

@Component({
    selector: 'app-activation-expired-dialog',
    templateUrl: './activation-expired-dialog.component.html',
    styleUrls: ['./activation-expired-dialog.component.css']
})
export class ActivationExpiredDialogComponent {

    constructor(public dialogRef: MatDialogRef<ActivationExpiredDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: DialogData,
                private userService: UserService) {

    }

    onNoClick(userId): void {
        this.userService.deleteUser(userId).subscribe(() => {
            this.dialogRef.close();
            alert('User is deleted!!!');
        });
    }


}
