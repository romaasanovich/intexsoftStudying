import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {AppSettings} from '../../../app.settings';


const httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
};

@Injectable()
export class ImageService {

    constructor(private http: HttpClient) {
    }

    public getImages(bookId) {
        return this.http.get<string[]>(`${AppSettings.URL}/images/${bookId}`);
    }

}
