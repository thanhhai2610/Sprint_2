package vn.thanhhai.model.account;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class PasswordResetToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String token;
    private String expiryDate;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName = "id")
    @JsonManagedReference
    private Account account;

    public PasswordResetToken() {
    }

    public PasswordResetToken(Integer id, String token, String expiryDate, Boolean status, Account account) {
        this.id = id;
        this.token = token;
        this.expiryDate = expiryDate;
        this.status = status;
        this.account = account;
    }

    public PasswordResetToken(String token, String expiryDate, Boolean status, Account account) {
        this.token = token;
        this.expiryDate = expiryDate;
        this.status = status;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}