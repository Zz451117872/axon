package com.zhang.userorderticketevent.ticket;

import com.zhang.userorderticketevent.ticket.command.TicketCreateCommand;
import com.zhang.userorderticketevent.ticket.command.TicketLockCommand;
import com.zhang.userorderticketevent.ticket.command.TicketMoveCommand;
import com.zhang.userorderticketevent.ticket.command.TicketUnlockCommand;
import com.zhang.userorderticketevent.ticket.event.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.Date;

import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;

/**
 * Created by aa on 2018/7/8.
 */

@Aggregate
public class Ticket {

    @AggregateIdentifier
    private String id;
    private String name;
    private String locker;
    private String owner;
    private Integer amount;
    private Long version;

    public Ticket() {
    }

    @CommandHandler
    public Ticket(TicketCreateCommand command ){
        apply( new TicketCreatedEvent( command.getId() , command.getName() , command.getAmount()));
    }

    @CommandHandler
    public void handler(TicketLockCommand command){
        if( this.id != command.getId() ){
            throw new RuntimeException("锁票id不一至");
        }
        if( this.locker != null  ){
            if( this.locker != command.getLocker() ){
                apply ( new TicketLockFailedEvent( command.getId() , command.getLocker() ,command.getOid()));
            }else{
                throw new RuntimeException("票已被自己锁定");
            }
        }else{
            apply ( new TicketLockedEvent( command.getId() , command.getLocker() ,command.getOid()));
        }
    }

    @CommandHandler
    public void handler(TicketMoveCommand command){
        apply( new TicketMovedEvent( command.getId() , command.getOwner() , command.getOid() ));
    }

    @CommandHandler
    public void handler(TicketUnlockCommand command){
        apply ( new TicketUnlockedEvent( command.getId() , command.getLocker() ,command.getOid() ));
    }

    @EventSourcingHandler
    public void on( TicketCreatedEvent event ){
        this.id = event.getId();
        this.amount = event.getAmount();
        this.locker = null;
        this.owner = null;
        this.name = event.getName();
        this.version = new Date().getTime();
    }

    @EventSourcingHandler
    public void on(TicketLockedEvent event ){
        if( this.id != event.getId() ){
            throw new RuntimeException("锁票id不一至");
        }
        if( this.locker != null  ){
            if( this.locker != event.getLocker() ){
                throw new RuntimeException("票已被他人锁定");
            }else{
                throw new RuntimeException("票已被自己锁定");
            }
        }else{
            this.locker = event.getLocker();
        }
    }

    @EventSourcingHandler
    public void on( TicketLockFailedEvent event ){
        this.locker = null;
    }

    @EventSourcingHandler
    public void on(TicketMovedEvent event ){
        if( this.id != event.getId() ){
            throw new RuntimeException("提票id不一至");
        }
        if( this.owner != null  ){
            if( this.owner != event.getOwner() ){
                throw new RuntimeException("票已被他人提走");
            }else{
                throw new RuntimeException("票已被自己提走");
            }
        }else{
            this.locker = event.getOwner();
        }
    }


    @EventSourcingHandler
    public void on(TicketUnlockedEvent event ){
        if( this.id != event.getId() ){
            throw new RuntimeException("解锁票id不一至");
        }
        if( this.locker != null  ){
            if( this.locker != event.getLocker() ){
                throw new RuntimeException("锁票人不是自己");
            }else{
                this.locker = null;
            }
        }else{
            throw new RuntimeException("票还未被锁定");
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

    public String getLocker() {
        return locker;
    }

    public void setLocker(String locker) {
        this.locker = locker;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
