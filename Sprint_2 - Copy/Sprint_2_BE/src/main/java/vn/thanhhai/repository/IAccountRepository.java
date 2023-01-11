package vn.thanhhai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.thanhhai.model.account.Account;

public interface IAccountRepository extends JpaRepository<Account, Integer> {

    @Query(
            value = " select * from account where username = :username ",
            nativeQuery = true
    )
    Account findAccountByUsername(@Param("username") String username);

}