import {AccountRole} from './account_role';
import {User} from '../users/user';

export interface Account {
  id?: number;
  username?: string;
  email?: string;
  password?: string;
  enabled?: number;
  statusLock?: boolean;
  deleteStatus?: boolean;
  // accountRoles?: AccountRole;
  // user?: User;
}
