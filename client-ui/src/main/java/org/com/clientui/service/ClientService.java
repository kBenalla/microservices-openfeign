package org.com.clientui.service;

import lombok.AllArgsConstructor;
import org.com.clientui.beans.CommandBean;
import org.com.clientui.beans.PaymentBean;
import org.com.clientui.beans.PaymentType;
import org.com.clientui.beans.ProductBean;
import org.com.clientui.dtos.FullResponse;
import org.com.clientui.proxies.MicroserviceCommandProxy;
import org.com.clientui.proxies.MicroservicePaymentProxy;
import org.com.clientui.proxies.MicroserviceProductProxy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientService {
    private MicroserviceProductProxy productProxy;
    private MicroserviceCommandProxy commandProxy;
    private MicroservicePaymentProxy paymentProxy;
    
    public List<ProductBean> findAllProducts(){
        return productProxy.findAllProducts();
    }

    public ProductBean findProductById(Integer productId){
        return productProxy.findProductById(productId);
    }

    public FullResponse saveCommand(Integer productId, Integer quantity){
        CommandBean commandBean=commandProxy.saveCommand(productId,quantity);
        return FullResponse.builder()
                .commandBean(commandBean)
                .productBean(productProxy.findProductById(commandBean.getProductId()))
                .build();
    }

    public FullResponse savePayment(Integer commandId, PaymentType type){
        PaymentBean paymentBean=paymentProxy.savePayment(commandId,type);
        CommandBean commandBean=commandProxy.findCommandById(paymentBean.getCommandId());

        return FullResponse.builder()
                .productBean(productProxy.findProductById(commandBean.getProductId()))
                .commandBean(commandBean)
                .paymentBean(paymentBean)
                .build();
    }
}
