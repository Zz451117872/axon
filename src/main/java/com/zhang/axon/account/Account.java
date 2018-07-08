package com.zhang.axon.account;

import com.zhang.axon.command.AccountCreateCommand;
import com.zhang.axon.command.AccountInCommand;
import com.zhang.axon.command.AccountOutCommand;
import com.zhang.axon.event.AccountCreateEvent;
import com.zhang.axon.event.AccountInEvent;
import com.zhang.axon.event.AccountOutEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.TargetAggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import javax.persistence.Entity;
import javax.persistence.Id;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

@Aggregate
public class Account {

    @AggregateIdentifier
    private String id;

    private Integer amount;

    public Account() {
    }

    @CommandHandler
    public Account(AccountCreateCommand command){
        apply( new AccountCreateEvent( command.getId() ));
    }

    @EventSourcingHandler
    public void on( AccountCreateEvent event ){
        this.id = event.getId();
        this.amount = 0 ;
    }

    @CommandHandler
    public void handler(AccountInCommand command ){
        apply ( new AccountInEvent( command.getId() , command .getAmount()));
    }

    @EventSourcingHandler
    public void on( AccountInEvent event){
        this.amount += event.getAmount();
    }

    @CommandHandler
    public void handler(AccountOutCommand command){
        apply ( new AccountOutEvent( command.getId() , command .getAmount()));
    }

    @EventSourcingHandler
    public void on( AccountOutEvent event){
        if( this.amount >= event.getAmount() ){
            this.amount -= event.getAmount();
        }else{
            throw new RuntimeException("余额不足");
        }

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
