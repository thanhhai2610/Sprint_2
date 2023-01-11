package vn.thanhhai.model.account;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class LockAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String startDay;
    private String endDay;
    private String reason;
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName="id")
    @JsonBackReference
    private Account account;

    public LockAccount() {
    }

    public LockAccount(Integer id, String startDay, String endDay, String reason, Account account) {
        this.id = id;
        this.startDay = startDay;
        this.endDay = endDay;
        this.reason = reason;
        this.account = account;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

