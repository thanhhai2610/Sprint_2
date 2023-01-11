import {Watch} from "../product/watch";
import {ProductOrder} from "./product_order";

export interface ProductOrderDetail {
  id?: number;
  quantity?: number;
  watch?: Watch;
  productOrder?: ProductOrder;
  deleteStatus?: boolean;
}
