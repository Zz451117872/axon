package com.zhang.userorderticketevent.order.query;

import com.zhang.userorderticketevent.customer.command.OrderPayCommand;
import com.zhang.userorderticketevent.customer.event.OrderPayFaildEvent;
import com.zhang.userorderticketevent.customer.event.OrderPayedEvent;
import com.zhang.userorderticketevent.order.command.OrderFaildCommand;
import com.zhang.userorderticketevent.order.command.OrderFinishCommand;
import com.zhang.userorderticketevent.order.event.OrderCreatedEvent;
import com.zhang.userorderticketevent.order.event.OrderFaildedEvent;
import com.zhang.userorderticketevent.order.event.OrderFinishedEvent;
import com.zhang.userorderticketevent.ticket.command.TicketLockCommand;
import com.zhang.userorderticketevent.ticket.command.TicketMoveCommand;
import com.zhang.userorderticketevent.ticket.command.TicketUnlockCommand;
import com.zhang.userorderticketevent.ticket.event.TicketLockFailedEvent;
import com.zhang.userorderticketevent.ticket.event.TicketLockedEvent;
import com.zhang.userorderticketevent.ticket.event.TicketMovedEvent;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.callbacks.LoggingCallback;
import org.axonframework.eventhandling.saga.EndSaga;
import org.axonframework.eventhandling.saga.SagaEventHandler;
import org.axonframework.eventhandling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import static org.axonframework.commandhandling.GenericCommandMessage.asCommandMessage;

@Saga
public class OrderManageSaga {

    Logger log = LoggerFactory.getLogger( OrderManageSaga.class );
    private String oid;
    private String cid;
    private String tid;
    private Integer amount;

    @Autowired
    private transient CommandBus commandBus;

    @StartSaga
    @SagaEventHandler( associationProperty = "id")
    public void on(OrderCreatedEvent event ){
        oid = event.getId();
        cid = event.getCid();
        tid = event.getTid();
        amount = event.getAmount();
        TicketLockCommand command = new TicketLockCommand(event.getTid(), event.getCid() ,event.getId());
        commandBus.dispatch( asCommandMessage( command) , LoggingCallback.INSTANCE );
    }

    @SagaEventHandler( associationProperty = "oid")
    public void on(TicketLockedEvent event ){
        OrderPayCommand command = new OrderPayCommand( oid , cid ,amount);
        commandBus.dispatch( asCommandMessage( command) , LoggingCallback.INSTANCE );
    }

    @SagaEventHandler( associationProperty = "oid")
    public void on(TicketLockFailedEvent event ){
        OrderFaildCommand orderFaildCommand = new OrderFaildCommand( oid ,"lock faild");
        commandBus.dispatch( asCommandMessage( orderFaildCommand) , LoggingCallback.INSTANCE );
    }

    @SagaEventHandler( associationProperty = "oid")
    public void on(OrderPayedEvent event){
        TicketMoveCommand command = new TicketMoveCommand( tid , cid );
        commandBus.dispatch( asCommandMessage( command) , LoggingCallback.INSTANCE );
    }

    @SagaEventHandler( associationProperty = "oid")
    public void on(OrderPayFaildEvent event){
        TicketUnlockCommand command = new TicketUnlockCommand( tid ,cid );
        commandBus.dispatch( asCommandMessage( command) , LoggingCallback.INSTANCE );

        OrderFaildCommand orderFaildCommand = new OrderFaildCommand( oid ,"pay faild");
        commandBus.dispatch( asCommandMessage( orderFaildCommand) , LoggingCallback.INSTANCE );
    }

    @SagaEventHandler( associationProperty = "oid")
    public void on(TicketMovedEvent event){
        OrderFinishCommand command = new OrderFinishCommand( oid );
        commandBus.dispatch( asCommandMessage( command) , LoggingCallback.INSTANCE );
    }

    @EndSaga
    @SagaEventHandler( associationProperty = "oid")
    public void end(OrderFaildedEvent event ){
        log.debug( "order faild :", event.getId());
    }

    @EndSaga
    @SagaEventHandler( associationProperty = "oid")
    public void end(OrderFinishedEvent event ){
        log.debug( "order finish :", event.getId());
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
