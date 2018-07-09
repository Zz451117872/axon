package com.zhang.userorderticketevent.customer.event;

public class OrderPayFaildEvent {

    private String cid;
    private String tid;
    private String oid;

    public OrderPayFaildEvent(String cid, String tid , String oid) {
        this.cid = cid;
        this.tid = tid;
        this.oid = oid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
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
