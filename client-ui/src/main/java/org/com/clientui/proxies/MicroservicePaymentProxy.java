package org.com.clientui.proxies;

import org.com.clientui.beans.PaymentBean;
import org.com.clientui.beans.PaymentType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservice-payment", url = "${application.config.microservice-payment-url}")
public interface MicroservicePaymentProxy {
    @PostMapping("/payments")
    PaymentBean savePayment(@RequestParam Integer commandId, @RequestHeader PaymentType type);
}
