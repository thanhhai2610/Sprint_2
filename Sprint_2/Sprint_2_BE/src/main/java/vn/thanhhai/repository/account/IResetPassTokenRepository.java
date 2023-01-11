package vn.thanhhai.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.thanhhai.model.account.PasswordResetToken;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IResetPassTokenRepository extends JpaRepository<PasswordResetToken, Integer> {

    @Query(value = "select* from password_reset_token where token =:token and status = 0;", nativeQuery = true)
    PasswordResetToken findByToken(@Param(value = "token") String token);

    @Modifying
    @Query(value = "insert into password_reset_token (expiry_date, status, token, account_id) " +
            "values (:expiry, 0, :token, :accountId )", nativeQuery = true)
    @Transactional
    void createToken( @Param("expiry") String expiry,
                      @Param("token") String token,
                      @Param("accountId") String accountId);

    @Query(value = "select* from password_reset_token where account_id =:accountId and status = 0;", nativeQuery = true)
    List<PasswordResetToken> findTokenByAccountId(String accountId);
}
