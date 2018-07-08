package com.zhang.userorderticketevent.ticket.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Created by aa on 2018/7/9.
 */
public class TicketMoveCommand {

    @TargetAggregateIdentifier
    private String id;
    private String owner;

    public TicketMoveCommand(String id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
