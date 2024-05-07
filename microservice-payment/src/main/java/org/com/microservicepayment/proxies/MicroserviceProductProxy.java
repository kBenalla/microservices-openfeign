package org.com.microservicepayment.proxies;

import org.com.microservicepayment.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-product",url = "localhost:8081")
public interface MicroserviceProductProxy {

    @GetMapping("/products/{productId}")
    ProductBean findProductById(@PathVariable("productId") Integer productId);
}
