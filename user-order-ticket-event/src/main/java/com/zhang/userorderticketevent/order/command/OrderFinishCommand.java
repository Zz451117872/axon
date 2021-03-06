package com.zhang.userorderticketevent.order.command;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

/**
 * Created by aa on 2018/7/9.
 */
public class OrderFinishCommand {

    @TargetAggregateIdentifier
    private String id;

    public OrderFinishCommand(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
