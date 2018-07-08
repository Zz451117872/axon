package com.zhang.userorderticketevent.customer.web;

import com.zhang.userorderticketevent.customer.command.CustomerCreateCommand;
import com.zhang.userorderticketevent.customer.command.CustomerInCommand;
import com.zhang.userorderticketevent.customer.command.CustomerOutCommand;
import com.zhang.userorderticketevent.customer.query.CustomerDao;
import com.zhang.userorderticketevent.customer.query.CustomerEntry;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping("/add")
    @ResponseBody
    public String add( String name , String password ){
        String id = UUID.randomUUID().toString();
        CustomerCreateCommand command = new CustomerCreateCommand( id , name , password );
        commandGateway.send( command );
        return id;
    }

    @RequestMapping("/in")
    @ResponseBody
    public String in(String id, Integer amount ){
        CustomerInCommand command = new CustomerInCommand( id , amount);
        commandGateway.send( command );
        return id;
    }

    @RequestMapping("/out")
    @ResponseBody
    public String out(String id, Integer amount  ){
        CustomerOutCommand command = new CustomerOutCommand( id ,amount );
        commandGateway.send( command );
        return id;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<CustomerEntry> list( ){
        return customerDao.findAll();
    }
}
