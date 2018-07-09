package com.zhang.userorderticketevent.order.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Created by aa on 2018/7/9.
 */
public class OrderCreateCommand {

    @TargetAggregateIdentifier
    private String id;
    private String cid;
    private String tid;
    private Integer amount;

    public OrderCreateCommand(String id, String cid, String tid , Integer amount) {
        this.id = id;
        this.cid = cid;
        this.tid = tid;
        this.amount = amount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}
