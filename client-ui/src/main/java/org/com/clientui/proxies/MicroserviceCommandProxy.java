package org.com.clientui.proxies;

import org.com.clientui.beans.CommandBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice-command", url = "${application.config.microservice-command-url}")
public interface MicroserviceCommandProxy {

    @PostMapping("/commands")
    CommandBean saveCommand(@RequestParam Integer productId, @RequestParam Integer quantity);

    @GetMapping("/commands/{id}")
    CommandBean findCommandById(@PathVariable("id") Integer id);

}
