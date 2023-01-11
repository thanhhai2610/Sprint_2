import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListComponent} from './component/product/list/list.component';
import {CreateComponent} from './component/product/create/create.component';
import {EditComponent} from './component/product/edit/edit.component';
import {ProductDetailComponent} from './component/product/product-detail/product-detail.component';
import {HomeComponent} from './component/home/home.component';
import {LoginComponent} from './component/security/login/login.component';
import {CartComponent} from './component/payment/cart/cart.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'create', component: CreateComponent},
  {path: 'detail', component: ProductDetailComponent},
  {path: 'login', component: LoginComponent},
  {path: 'cart', component: CartComponent},
  {path: 'edit/:id', component: EditComponent},
  {path: 'create', component: CreateComponent}
  // {path: 'delete/:id', component: DeleteComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
