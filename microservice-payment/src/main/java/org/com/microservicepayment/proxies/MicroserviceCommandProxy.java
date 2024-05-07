package org.com.microservicepayment.proxies;

import org.com.microservicepayment.beans.CommandBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "microservice-command",url = "localhost:8082")
public interface MicroserviceCommandProxy {

    @GetMapping("/commands/{id}")
    CommandBean findByCommandId(@PathVariable("id") Integer id);

    @PutMapping("/commands/{id}")
    void updateCommand(@PathVariable("id") Integer id, @RequestHeader Boolean paidCommand);
}
