import {AccountRole} from "./account_role";

export interface Role {
  id: string;
  name: string;
  accountRole?: AccountRole;
}
