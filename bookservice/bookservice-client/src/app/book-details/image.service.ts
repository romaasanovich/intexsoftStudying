import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {AppSettings} from '../../../app.settings';


@Injectable()
export class ImageService {

    constructor(private http: HttpClient) {
    }

    public getImages(bookId) {
        return this.http.get<string[]>(`${AppSettings.API_URL}/images/${bookId}`);
    }

}
