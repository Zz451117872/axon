package com.zhang.userorderticketevent.ticket.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Created by aa on 2018/7/9.
 */
public class TicketMoveCommand {

    @TargetAggregateIdentifier
    private String id;
    private String owner;
    private String oid;

    public TicketMoveCommand(String id, String owner , String oid) {
        this.id = id;
        this.owner = owner;
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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
