package com.sda.corneliacalin.webshop.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="account")
public class Account {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="login")
    private String login;



    @Column(name="password")
    private String password;

    @Column(name="billing_address")
    private String billingAddress;
    @Column(name="is_closed")
    private Boolean isClosed;
    @Column(name="creation_date")
    private Date creationDate;
    @Column(name="closed_date")
    private Date closedDate;




    public void setId(Long id) {
        this.id = id;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setClosedDate(Date closedDate) {
        this.closedDate = closedDate;
    }

    public Long getId() {
        return id;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getClosedDate() {
        return closedDate;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", billingAddress='" + billingAddress + '\'' +
                ", isClosed=" + isClosed +
                ", creationDate=" + creationDate +
                ", closedDate=" + closedDate +
                '}';
    }
}
