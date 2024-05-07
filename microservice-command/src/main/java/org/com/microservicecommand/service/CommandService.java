package org.com.microservicecommand.service;

import lombok.AllArgsConstructor;
import org.com.microservicecommand.Beans.ProductBean;
import org.com.microservicecommand.entities.Command;
import org.com.microservicecommand.exceptions.CommandNotFoundException;
import org.com.microservicecommand.exceptions.ProductNotFoundException;
import org.com.microservicecommand.proxies.MicroserviceProductProxy;
import org.com.microservicecommand.repository.CommandRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommandService {

    private CommandRepository commandRepository;
    private MicroserviceProductProxy productProxy;

    public List<Command> findAllCommands(){
        List<Command> commands=commandRepository.findAll();
        if (commands.isEmpty()) throw new CommandNotFoundException();
        return commands;
    }

    public Command findCommandById(Integer id){
        return commandRepository.findById(id).orElseThrow(CommandNotFoundException::new);
    }

    public Command saveCommand(Integer productId, Integer quantity)  {
        Optional<ProductBean> productBean=productProxy.findProductById(productId);
        if (productBean.isEmpty()) throw new ProductNotFoundException();
        return commandRepository.save(Command.builder()
                        .productId(productId)
                        .dateTime(LocalDateTime.now())
                        .quantity(quantity)
                        .paidCommand(false)
                        .build());
    }

    public void updateCommand(Integer id,Boolean paidCommand){
        Command existingCommand=findCommandById(id);
        existingCommand.setPaidCommand(paidCommand);
        commandRepository.save(existingCommand);
    }
}
