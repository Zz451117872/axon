package com.zhang.userorderticketevent.ticket.web;

import com.zhang.userorderticketevent.ticket.command.TicketCreateCommand;
import com.zhang.userorderticketevent.ticket.query.TicketDao;
import com.zhang.userorderticketevent.ticket.query.TicketEntry;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 * Created by aa on 2018/7/9.
 */
@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketDao ticketDao;

    @Autowired
    private CommandGateway commandGateway;

    @RequestMapping("/add")
    @ResponseBody
    public String add( String name , Integer amount ){
        System.out.println( "xxxxxx");
        String id = UUID.randomUUID().toString();
        TicketCreateCommand command = new TicketCreateCommand( id , name , amount );
        commandGateway.send( command );
        return id;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<TicketEntry> list(){
        return ticketDao.findAll();
    }

}
