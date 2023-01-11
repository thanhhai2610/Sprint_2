package vn.thanhhai.service.account;

import vn.thanhhai.model.account.Account;

import java.util.List;

public interface IAccountService {

    Account findAccountByUsername(String username);
}
