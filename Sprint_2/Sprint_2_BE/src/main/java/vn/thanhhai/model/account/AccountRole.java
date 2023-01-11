package vn.thanhhai.model.account;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class AccountRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonManagedReference
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "role_id",referencedColumnName = "id")
    @JsonManagedReference
    private Role role;
    @ManyToOne
    @JoinColumn(name = "account_id",referencedColumnName ="id")
    @JsonManagedReference
    private Account account;

    public AccountRole() {
    }

    public AccountRole(Integer id, Role role, Account account) {
        this.id = id;
        this.role = role;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
