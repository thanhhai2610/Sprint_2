import {User} from "../users/user";
import {ProductOrderDetail} from "./product_order_detail";

export interface ProductOrder {
  id?: number;
  orderDate?: string;
  user?: User;
  deleteStatus?: boolean;
  productOrderDetails?: ProductOrderDetail;
}
