package com.zhang.userorderticketevent.customer.event;

public class CustomerCreatedEvent {
    private String id;
    private String name;
    private String passwrod;

    public CustomerCreatedEvent(String id, String name, String passwrod) {
        this.id = id;
        this.name = name;
        this.passwrod = passwrod;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }


}
