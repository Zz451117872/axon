package com.zhang.userorderticketevent.order.query;

import com.zhang.userorderticketevent.order.event.OrderCreatedEvent;
import com.zhang.userorderticketevent.ticket.Ticket;
import com.zhang.userorderticketevent.ticket.query.TicketDao;
import com.zhang.userorderticketevent.ticket.query.TicketEntry;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by aa on 2018/7/9.
 */
@Component
public class OrderProjecter {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private TicketDao ticketDao;

    @EventHandler
    public void on(OrderCreatedEvent event){
        OrderEntry entry = new OrderEntry();
        entry.setId( event.getId() );
        entry.setCid( event.getCid() );
        entry.setTid( event.getTid() );
        entry.setStatus( 0 );
        TicketEntry ticket = ticketDao.getOne( entry.getTid() );
        entry.setAmount( ticket.getAmount() );
        entry.setVersion( new Date().getTime() );

        orderDao.save( entry );
    }
}
