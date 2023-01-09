import { Injectable } from '@angular/core';
import {Watch} from "../model/product/watch";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {WatchDto} from "../model/dto/watch_dto";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Category} from "../model/product/category";
import {Brand} from "../model/product/brand";

@Injectable({
  providedIn: 'root'
})
export class WatchServiceService {


  private watches: Watch[];
  private productDetailId: any;


  constructor(protected httpClient: HttpClient) {
  }

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    }),
    'Access-Control-Allow-Origin': 'http://localhost:4200',
    'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
  };


  addProduct(watchDto: WatchDto) {
    return this.httpClient.post<Watch>(environment.apiUrl + '/api/v1/products/create', watchDto);
  }

  getListBrand(): Observable<Brand[]> {
    return this.httpClient.get<Brand[]>(environment.api_url_list_brand);
  }
}
