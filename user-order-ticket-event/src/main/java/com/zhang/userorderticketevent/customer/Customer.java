package com.zhang.userorderticketevent.customer;

import com.zhang.userorderticketevent.customer.command.CustomerCreateCommand;
import com.zhang.userorderticketevent.customer.command.CustomerInCommand;
import com.zhang.userorderticketevent.customer.command.CustomerOutCommand;
import com.zhang.userorderticketevent.customer.event.CustomerCreatedEvent;
import com.zhang.userorderticketevent.customer.event.CustomerInedEvent;
import com.zhang.userorderticketevent.customer.event.CustomerOutedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Customer {

    @AggregateIdentifier
    private String id;

    private String name;

    private String password;

    private Integer amount;


    public Customer() {
    }

    @CommandHandler
    public Customer(CustomerCreateCommand command){
        apply ( new CustomerCreatedEvent( command.getId() , command.getName() , command.getPassword() ));
    }

    @EventSourcingHandler
    public void handler( CustomerCreatedEvent event){
        this.id = event.getId();
        this.name = event.getName();
        this.password = event.getPasswrod();
        this.amount = 0;
    }

    @CommandHandler
    public void in(CustomerInCommand command){
        apply( new CustomerInedEvent( command.getId() , command.getAmount() ));
    }

    @EventSourcingHandler
    public void in( CustomerInedEvent event ){
        this.amount += event.getAmount();
    }

    @CommandHandler
    public void out(CustomerOutCommand command){
        apply( new CustomerOutedEvent( command.getId() , command.getAmount() ));
    }

    @EventSourcingHandler
    public void out( CustomerOutedEvent event ){
        if( this.amount >= event.getAmount() ){
            this.amount -= event.getAmount();
        }else{
            throw new RuntimeException( " 余额不足 ");
        }
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", amount=" + amount +
                '}';
    }
}
