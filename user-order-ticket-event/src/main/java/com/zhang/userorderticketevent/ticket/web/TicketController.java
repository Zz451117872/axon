package com.zhang.userorderticketevent.ticket.web;

import com.zhang.userorderticketevent.ticket.query.TicketDao;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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


}
