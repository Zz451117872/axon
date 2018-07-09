package com.zhang.userorderticketevent.ticket.query;

import com.zhang.userorderticketevent.ticket.event.*;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by aa on 2018/7/9.
 */

@Component
public class TicketProjecter {

   @Autowired
   private TicketDao ticketDao;

    @EventHandler
    public void on( TicketCreatedEvent event ){
        TicketEntry entry = new TicketEntry();
        entry.setId( event.getId() );
        entry.setName( event.getName() );
        entry.setAmount( event.getAmount() );
        entry.setLocker( null );
        entry.setOwner( null );
        entry.setVersion( new Date().getTime() );
        ticketDao.save( entry );
    }

    @EventHandler
    public void on(TicketLockedEvent event ){
       TicketEntry entry = ticketDao.getOne( event.getId() );
       entry.setLocker( event.getLocker() );
       ticketDao.save( entry );
    }

    @EventHandler
    public void on(TicketMovedEvent event ){
        TicketEntry entry = ticketDao.getOne( event.getId() );
        entry.setOwner( event.getOwner() );
        ticketDao.save( entry );
    }

    @EventHandler
    public void on(TicketUnlockedEvent event ){
       TicketEntry entry = ticketDao.getOne( event.getId() );
       entry.setLocker( null );
       ticketDao.save( entry );
    }

    @EventHandler
    public void on(TicketLockFailedEvent event ){

    }

}
