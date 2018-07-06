package com.zhang.axon.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class AccountCreateCommand {

    @TargetAggregateIdentifier
    private String id;

    public AccountCreateCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
