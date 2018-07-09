package com.zhang.userorderticketevent.order.web;

import com.zhang.userorderticketevent.order.command.OrderCreateCommand;
import com.zhang.userorderticketevent.order.query.OrderDao;
import com.zhang.userorderticketevent.order.query.OrderEntry;
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
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private OrderDao orderDao;

    @RequestMapping("/add")
    @ResponseBody
    public String createOrder( String cid, String tid ,Integer amount){
        String id = UUID.randomUUID().toString();
        OrderCreateCommand command = new OrderCreateCommand( id, cid , tid ,amount);
        commandGateway.send( command );
        return id;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<OrderEntry> list(){
        return orderDao.findAll();
    }
}
