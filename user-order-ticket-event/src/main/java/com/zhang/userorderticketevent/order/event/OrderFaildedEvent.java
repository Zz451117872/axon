package com.zhang.userorderticketevent.order.event;

/**
 * Created by aa on 2018/7/9.
 */
public class OrderFaildedEvent {

    private String id;
    private String reason;

    public OrderFaildedEvent(String id, String reason) {
        this.id = id;
        this.reason = reason;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
