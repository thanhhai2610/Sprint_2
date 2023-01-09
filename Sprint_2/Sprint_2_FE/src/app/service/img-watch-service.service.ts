import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {ImgWatch} from "../model/product/img_watch";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ImgWatchServiceService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    }),
    'Access-Control-Allow-Origin': 'http://localhost:4200',  // chấp nhận đường dẫn từ phía back-end
    'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'  // chấp nhận các method từ phía back-end
  };

  constructor(private httpClient: HttpClient) { }

  create(image): Observable<ImgWatch> {
    return this.httpClient.post<ImgWatch>(environment.api_url_list_images + '/create', image, this.httpOptions);
  }
}
