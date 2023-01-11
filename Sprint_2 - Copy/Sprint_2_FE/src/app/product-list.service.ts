import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../environments/environment";
import {Watch} from "./model/product/watch";

@Injectable({
  providedIn: 'root'
})
export class ProductListService {

  constructor(private httpClient: HttpClient) { }

  findAllProduct(): Observable<Watch[]> {
    return this.httpClient.get<Watch[]>(environment.api_url_list_watch);
  }
}
