import {Component, OnInit} from '@angular/core';
import {AuthentificationService} from '../login/authentification.service';
import {Router} from '@angular/router';
import {AppComponent} from '../app.component';

@Component({
    selector: 'app-logout',
    templateUrl: './logout.component.html',
    styleUrls: ['./logout.component.css']
})
export class LogoutComponent implements OnInit {

    constructor(private router: Router, private authentificationService: AuthentificationService) {
    }

    ngOnInit() {
        this.authentificationService.logout().subscribe(() => {
            alert('You are logout!!!');
        });
        this.router.navigate([AppComponent]);
    }

}

