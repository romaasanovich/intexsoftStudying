import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';



const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class LoginService {

  constructor(private http: HttpClient) {
  }


  public login(username, password) {
    const frmData = new FormData();
    frmData.append('username', username);
    frmData.append('password', password);
    frmData.append('submit','Login');
    return this.http.post('http://localhost:8080/bookservice/login', frmData).subscribe();
  }

}
