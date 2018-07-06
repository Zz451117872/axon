package com.zhang.axon.query;

import com.zhang.axon.event.AccountCreateEvent;
import com.zhang.axon.event.AccountInEvent;
import com.zhang.axon.event.AccountOutEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountProjecter {

    @Autowired
    private AccountRepositoy accountRepositoy;

    @EventHandler
    public void on(AccountCreateEvent event){
        AccountEntry entry = new AccountEntry();
        entry.setId( event.getId() );
        entry.setAmount( 0 );
        accountRepositoy.save( entry );
    }

    @EventHandler
    public void in(AccountInEvent event){
        AccountEntry entry = accountRepositoy.getOne( event.getId() );
        entry.setAmount( entry.getAmount() + event.getAmount() );
        accountRepositoy.save( entry );
    }

    @EventHandler
    public void out(AccountOutEvent event){
        AccountEntry entry = accountRepositoy.getOne( event.getId() );
        if( entry.getAmount() >= event.getAmount() ){
            entry.setAmount( entry.getAmount() - event.getAmount() );
            accountRepositoy.save( entry );
        }else{
            throw new RuntimeException("余额不足");
        }

    }

}
