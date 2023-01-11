package vn.thanhhai.service.account;

import vn.thanhhai.model.account.Account;
import vn.thanhhai.service.IGeneralService;

public interface IAccountService extends IGeneralService<Account> {

    Account findAccountByUsername(String username);

    Account findAccountByEmail(String email);

}