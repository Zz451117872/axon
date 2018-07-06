package com.zhang.axon.query;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "account")
public class AccountEntry {

    @Id
    private String id;
    private Integer amount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
