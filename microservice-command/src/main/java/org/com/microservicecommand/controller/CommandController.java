package org.com.microservicecommand.controller;

import lombok.AllArgsConstructor;
import org.com.microservicecommand.entities.Command;
import org.com.microservicecommand.exceptions.ProductNotFoundException;
import org.com.microservicecommand.service.CommandService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommandController {
    private CommandService commandService;

    @GetMapping("/commands")
    public List<Command> getCommands(){
        return commandService.findAllCommands();
    }
    @GetMapping("/commands/{id}")
    public Command getCommand(@PathVariable("id") Integer id){
        return commandService.findCommandById(id);
    }

    @PostMapping("/commands")
    @ResponseStatus(HttpStatus.CREATED)
    public Command saveCommand(@RequestParam Integer productId,@RequestParam Integer quantity) {
        return commandService.saveCommand(productId,quantity);
    }

    @PutMapping("/commands/{id}")
    public void updateCommand(@PathVariable("id") Integer id,
                              @RequestHeader Boolean paidCommand){
        commandService.updateCommand(id,paidCommand);
    }

}
