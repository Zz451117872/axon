package com.zhang.userorderticketevent.ticket.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class TicketUnlockCommand {

    @TargetAggregateIdentifier
    private String id;
    private String locker;
    private String oid;

    public TicketUnlockCommand(String id, String locker , String oid) {
        this.id = id;
        this.locker = locker;
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

    public String getLocker() {
        return locker;
    }

    public void setLocker(String locker) {
        this.locker = locker;
    }
}
