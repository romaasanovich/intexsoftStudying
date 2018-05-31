import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class ImportService {

    constructor(private http: HttpClient) {
    }

    public import(type: string) {
        return this.http.post(`http://localhost:8080/bookservice/api/import/${type}`, type);
    }
}
