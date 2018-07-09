package com.zhang.userorderticketevent.ticket.event;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class TicketLockFailedEvent {

    private String id;
    private String locker;
    private String oid;


    public TicketLockFailedEvent(String id, String locker ,String oid) {
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
