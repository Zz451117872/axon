package com.zhang.axon.web;

import com.zhang.axon.command.AccountCreateCommand;
import com.zhang.axon.command.AccountInCommand;
import com.zhang.axon.command.AccountOutCommand;
import com.zhang.axon.query.AccountEntry;
import com.zhang.axon.query.AccountRepositoy;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private CommandGateway commandGateway;

    @Autowired
    private AccountRepositoy accountRepositoy;

    @RequestMapping("/add")
    @ResponseBody
    public String add(){
        String id = UUID.randomUUID().toString();
        AccountCreateCommand command = new AccountCreateCommand( id );
          commandGateway.send( command );
          return id;
    }

    @RequestMapping("/in/{id}/{amount}")
    public void in(@PathVariable("id") String id , @PathVariable("amount") Integer amount){
        commandGateway.send( new AccountInCommand( id , amount ));
    }

    @RequestMapping("/out/{id}/{amount}")
    public void out(@PathVariable("id") String id , @PathVariable("amount") Integer amount){
        commandGateway.send( new AccountOutCommand( id , amount ));
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<AccountEntry> list(){
        return accountRepositoy.findAll();
    }
}
