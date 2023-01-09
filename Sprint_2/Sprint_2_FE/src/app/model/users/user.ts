import {Address} from "./address";
import {Account} from "../account/account";
import {UserType} from "./user_type";

export interface User {
  id?: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  phone?: string;
  birthday?: string;
  idCard?: string;
  avatar?: string;
  deleteStatus?: boolean;
  address?: Address;
  account?: Account;
  userType?: UserType;
}
