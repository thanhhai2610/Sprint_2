import { Component, OnInit } from '@angular/core';
import {FormGroup} from "@angular/forms";
import {ProductListService} from "../../product-list.service";
import {ToastrService} from "ngx-toastr";
import {Title} from "@angular/platform-browser";
import {Watch} from "../../model/product/watch";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  rfWatch: FormGroup;
  watch: Watch[];
  constructor( private productService: ProductListService,
               private toast: ToastrService,
               private title: Title) {
    this.title.setTitle('Home');
  }

  ngOnInit(): void {
    this.productService.findAllProduct().subscribe((data) => {
      this.watch = data;
      console.log(data);
    });
  }

}
