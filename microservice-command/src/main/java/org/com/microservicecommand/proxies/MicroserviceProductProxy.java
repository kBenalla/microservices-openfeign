package org.com.microservicecommand.proxies;

import org.com.microservicecommand.Beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "microservice-product",url = "localhost:8081")
public interface MicroserviceProductProxy {
    @GetMapping("/products/{productId}")
    Optional<ProductBean> findProductById(@PathVariable("productId") Integer productId);
}
