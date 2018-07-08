package com.zhang.userorderticketevent.customer.query;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "customer1")
public class CustomerEntry implements Serializable{

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String passwrod;

    @Column
    private Integer amount;

    public CustomerEntry(String id, String name, String passwrod, Integer amount) {
        this.id = id;
        this.name = name;
        this.passwrod = passwrod;
        this.amount = amount;
    }

    public CustomerEntry() {
    }

    @Override
    public String toString() {
        return "CustomerEntry{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passwrod='" + passwrod + '\'' +
                ", amount=" + amount +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
