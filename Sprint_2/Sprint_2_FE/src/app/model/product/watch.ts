import {Category} from "./category";
import {Brand} from "./brand";
import {ProductOrderDetail} from "../order/product_order_detail";
import {ImgWatch} from "./img_watch";

export interface Watch {
  id?: number;
  name?: string;
  faceDiameter?: string;
  waterproof?: string;
  faceMaterial?: string;
  strapSize?: string;
  wireMaterial?: string;
  shellMaterial?: string;
  designs?: string;
  warranty?: string;
  registerDay?: string;
  description?: string;
  price?: number;
  quantity?: number;
  avatar?: string;
  category?: Category;
  brand?: Brand;
  deleteStatus?: boolean;
  imgUrlProducts?: ImgWatch;
  productOrderDetails?: ProductOrderDetail;
}
