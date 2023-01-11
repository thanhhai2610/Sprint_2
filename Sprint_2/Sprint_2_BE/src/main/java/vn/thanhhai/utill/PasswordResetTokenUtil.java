package vn.thanhhai.utill;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.thanhhai.model.account.Account;
import vn.thanhhai.model.account.PasswordResetToken;
import vn.thanhhai.repository.account.IResetPassTokenRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Service
public class PasswordResetTokenUtil {
    private final int expiry = 60 * 24;

    @Autowired
    IResetPassTokenRepository resetPassTokenRepository;

    public PasswordResetToken validateToken(String token) {
        PasswordResetToken passwordResetToken = resetPassTokenRepository.findByToken(token);
        return passwordResetToken;

    }

    public PasswordResetToken createToken(Account account) {
        String token = UUID.randomUUID().toString();
        LocalDateTime expiryDate = LocalDateTime.now().plusMinutes(expiry);
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String expiry = expiryDate.format(format);
        String accountId = account.getId() + "";
        PasswordResetToken resetToken = new PasswordResetToken(token, expiry, false, account);
        resetPassTokenRepository.createToken(expiry, token, accountId);
        return resetToken;
    }

    public PasswordResetToken validateTokenByAccountId(String accountId, String token) {
        List<PasswordResetToken> tokenList = resetPassTokenRepository.findTokenByAccountId(accountId);
        for (int i = 0; i < tokenList.size(); i++) {
            if (tokenList.get(i).getToken().equals(token)) {
                return tokenList.get(i);
            }
        }
        return null;
    }
}
