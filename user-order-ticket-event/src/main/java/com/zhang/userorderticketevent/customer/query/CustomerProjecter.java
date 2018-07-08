package com.zhang.userorderticketevent.customer.query;

import com.zhang.userorderticketevent.customer.event.CustomerCreatedEvent;
import com.zhang.userorderticketevent.customer.event.CustomerInedEvent;
import com.zhang.userorderticketevent.customer.event.CustomerOutedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerProjecter {

    @Autowired
    private CustomerDao customerDao;

    @EventHandler
    public void on(CustomerCreatedEvent event){
        CustomerEntry entry = new CustomerEntry();
        entry.setId( event.getId() );
        entry.setAmount( 0 );
        customerDao.save( entry );
    }

    @EventHandler
    public void in(CustomerInedEvent event){
        CustomerEntry entry = customerDao.getOne( event.getId() );
        entry.setAmount( entry.getAmount() + event.getAmount() );
        customerDao.save( entry );
    }

    @EventHandler
    public void out(CustomerOutedEvent event){
        CustomerEntry entry = customerDao.getOne( event.getId() );
        if( entry.getAmount() >= event.getAmount() ){
            entry.setAmount( entry.getAmount() - event.getAmount() );
            customerDao.save( entry );
        }else{
            throw new RuntimeException("余额不足");
        }

    }
}
