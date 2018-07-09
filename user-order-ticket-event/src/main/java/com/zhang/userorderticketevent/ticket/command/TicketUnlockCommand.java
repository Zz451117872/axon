package com.zhang.userorderticketevent.ticket.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class TicketUnlockCommand {

    @TargetAggregateIdentifier
    private String id;
    private String locker;

    public TicketUnlockCommand(String id, String locker) {
        this.id = id;
        this.locker = locker;
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
