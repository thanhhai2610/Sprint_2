package vn.thanhhai.security.user_detail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.thanhhai.model.account.Account;
import vn.thanhhai.repository.account.IAccountRepository;
import vn.thanhhai.service.account.IAccountService;

@Service
public class MyUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private IAccountService accountService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.findAccountByUsername(username);

        if (account == null) {
            throw new UsernameNotFoundException("Username not found!");
        }

        return new MyUserDetail(account);
    }
}
