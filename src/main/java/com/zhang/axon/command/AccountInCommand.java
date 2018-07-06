package com.zhang.axon.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class AccountInCommand {

    @TargetAggregateIdentifier
    private String id;
    private Integer amount;

    public AccountInCommand(String id, Integer amount) {
        this.id = id;
        this.amount = amount;
    }

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
