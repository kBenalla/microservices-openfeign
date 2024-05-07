package org.com.clientui.controller;

import lombok.AllArgsConstructor;
import org.com.clientui.beans.CommandBean;
import org.com.clientui.beans.PaymentBean;
import org.com.clientui.beans.PaymentType;
import org.com.clientui.beans.ProductBean;
import org.com.clientui.dtos.FullResponse;
import org.com.clientui.proxies.MicroserviceCommandProxy;
import org.com.clientui.proxies.MicroservicePaymentProxy;
import org.com.clientui.proxies.MicroserviceProductProxy;
import org.com.clientui.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ClientController {
    private ClientService clientService;

    @GetMapping("/clients/products")
    public List<ProductBean> findAllProduct(){
        return clientService.findAllProducts();
    }

    @GetMapping("/clients/products/{id}")
    public ProductBean findProductById(@PathVariable("id") Integer id){
        return clientService.findProductById(id);
    }

    @PostMapping("/clients/products/{productId}/commands")
    @ResponseStatus(HttpStatus.CREATED)
    public FullResponse saveCommand(@PathVariable("productId") Integer id, @RequestParam Integer quantity){
        return clientService.saveCommand(id,quantity);
    }
    @PostMapping("/clients/commands/{commandId}/payments")
    @ResponseStatus(HttpStatus.CREATED)
    public FullResponse savePayment(@PathVariable("commandId") Integer commandId,
                                                    @RequestHeader PaymentType type){
        return clientService.savePayment(commandId,type);
    }


}
