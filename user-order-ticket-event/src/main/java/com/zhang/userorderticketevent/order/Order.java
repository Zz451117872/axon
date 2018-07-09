package com.zhang.userorderticketevent.order;

import com.zhang.userorderticketevent.order.command.OrderCreateCommand;
import com.zhang.userorderticketevent.order.event.OrderCreatedEvent;
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
public class Order {

    @AggregateIdentifier
    private String id;
    private String cid;
    private String tid;
    private Integer amount;
    private Integer status;
    private String reason;
    private Long version;

    public Order() {
    }

    @CommandHandler
    public Order(OrderCreateCommand command){
        apply( new OrderCreatedEvent( command.getId() , command.getCid() , command.getTid() ,command.getAmount()));
    }

    @EventSourcingHandler
   public void on( OrderCreatedEvent event ){
       this.id = event.getId();
        this.cid = event.getCid();
        this.tid = event.getTid();
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", cid='" + cid + '\'' +
                ", tid='" + tid + '\'' +
                ", amount=" + amount +
                ", status=" + status +
                ", reason='" + reason + '\'' +
                ", version=" + version +
                '}';
    }
}
