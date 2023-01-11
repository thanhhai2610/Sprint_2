package vn.thanhhai.model.account;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import vn.thanhhai.model.users.User;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;

    private String password;
    @Column(columnDefinition = "boolean default true")
    private Boolean statusLock;

    @Column(columnDefinition = "boolean default true")
    private Boolean deleteStatus;

    @JsonBackReference
    @OneToMany(mappedBy = "account",
            fetch = FetchType.EAGER)
    private Set<AccountRole> accountRoles;

    @JsonBackReference
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private Set<PasswordResetToken> passwordResetTokens;

    @OneToOne(mappedBy = "account")
    @JsonBackReference
    private User user;

    @OneToOne(mappedBy = "account")
    @JsonManagedReference
    private LockAccount lockAccount;

    public Account() {
    }

    public Account(Integer id, String username, String password, Boolean statusLock, Boolean deleteStatus, Set<AccountRole> accountRoles, Set<PasswordResetToken> passwordResetTokens, User user, LockAccount lockAccount) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.statusLock = statusLock;
        this.deleteStatus = deleteStatus;
        this.accountRoles = accountRoles;
        this.passwordResetTokens = passwordResetTokens;
        this.user = user;
        this.lockAccount = lockAccount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatusLock() {
        return statusLock;
    }

    public void setStatusLock(Boolean statusLock) {
        this.statusLock = statusLock;
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Set<AccountRole> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(Set<AccountRole> accountRoles) {
        this.accountRoles = accountRoles;
    }

    public Set<PasswordResetToken> getPasswordResetTokens() {
        return passwordResetTokens;
    }

    public void setPasswordResetTokens(Set<PasswordResetToken> passwordResetTokens) {
        this.passwordResetTokens = passwordResetTokens;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LockAccount getLockAccount() {
        return lockAccount;
    }

    public void setLockAccount(LockAccount lockAccount) {
        this.lockAccount = lockAccount;
    }
}
