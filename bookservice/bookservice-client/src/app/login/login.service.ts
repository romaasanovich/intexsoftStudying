import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json'})
};

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) {
  }




  public login(username, password) {

    const body = new URLSearchParams();
    body.set('username', username);
    body.set('password', password);
    body.set('submit', 'Login');
    const options = {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
    };
    // const frmData = new FormData();
    // frmData.append('username', username);
    // frmData.append('password', password);
    return this.http.post('http://localhost:8080/bookservice/login', body.toString(), options);
  }
}
