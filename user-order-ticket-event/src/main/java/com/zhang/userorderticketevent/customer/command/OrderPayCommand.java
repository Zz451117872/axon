package com.zhang.userorderticketevent.customer.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class OrderPayCommand {

    private String oid;
    @TargetAggregateIdentifier
    private String cid;
    private Integer amount;

    public OrderPayCommand(String oid, String cid, Integer amount) {
        this.oid = oid;
        this.cid = cid;
        this.amount = amount;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
