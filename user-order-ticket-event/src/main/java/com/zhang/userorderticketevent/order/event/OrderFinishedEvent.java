package com.zhang.userorderticketevent.order.event;

/**
 * Created by aa on 2018/7/9.
 */
public class OrderFinishedEvent {

    private String id;

    public OrderFinishedEvent(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
