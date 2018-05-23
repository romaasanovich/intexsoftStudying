import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Publisher } from '../entity/publisher.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class PublisherService {

  constructor(private http: HttpClient) {}


  public addPubl(publisher)  {
    return this.http.post('http://localhost:8080/bookservice/api/publisher/add', publisher);
  }

  public getPublishers() {
    return this.http.get<Publisher[]>('http://localhost:8080/bookservice/api/publishers');
  }

  public deletePublisher(publisher: Publisher)  {
    return this.http.delete(  'http://localhost:8080/bookservice/api/publisher/del' + '/' +  publisher.id.toString());
  }

}
