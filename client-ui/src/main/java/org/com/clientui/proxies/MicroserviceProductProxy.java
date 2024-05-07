package org.com.clientui.proxies;

import org.com.clientui.beans.ProductBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "microservice-product", url = "${application.config.microservice-product-url}")
public interface MicroserviceProductProxy {

    @GetMapping("/products")
    List<ProductBean> findAllProducts();

    @GetMapping("/products/{id}")
    ProductBean findProductById(@PathVariable("id") Integer id);

}
