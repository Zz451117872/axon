package com.zhang.userorderticketevent.order.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Created by aa on 2018/7/9.
 */
public class OrderFaildCommand {

    @TargetAggregateIdentifier
    private String id;

    private String reason;

    public OrderFaildCommand(String id, String reason) {
        this.id = id;
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
