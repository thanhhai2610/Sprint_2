import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Category} from "../model/product/category";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class CategoryServiceService {

  constructor(private httpClient: HttpClient) {
  }

  getListCategory(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(environment.categoryUrl);
  }
}
