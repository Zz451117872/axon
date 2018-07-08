package com.zhang.userorderticketevent.order.event;

/**
 * Created by aa on 2018/7/9.
 */
public class OrderCreatedEvent {

    private String id;
    private String cid;
    private String tid;

    public OrderCreatedEvent(String id, String cid, String tid) {
        this.id = id;
        this.cid = cid;
        this.tid = tid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }
}
