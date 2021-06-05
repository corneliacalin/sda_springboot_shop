package com.sda.corneliacalin.webshop.model;

import java.util.Date;

public class Account {
    private Long id;
    private String billingAddress;
    private boolean isClosed;
    private Date creationDate;
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
