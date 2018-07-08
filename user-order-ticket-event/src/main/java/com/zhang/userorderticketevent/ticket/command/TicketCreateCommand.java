package com.zhang.userorderticketevent.ticket.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Created by aa on 2018/7/9.
 */
public class TicketCreateCommand {

    @TargetAggregateIdentifier
    private String id;
    private String name;
    private Integer amount;

    public TicketCreateCommand(String id, String name, Integer amount) {
        this.id = id;
        this.name = name;
        this.amount = amount;

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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
