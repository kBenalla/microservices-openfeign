package org.com.microserviceproduct.controller;

import lombok.AllArgsConstructor;
import org.com.microserviceproduct.dtos.ProductRequest;
import org.com.microserviceproduct.entities.Product;
import org.com.microserviceproduct.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") Integer id){
        return productService.findProductById(id);
    }

    @PostMapping("/products")
    @ResponseStatus(HttpStatus.CREATED)
    public Product saveProduct(@RequestBody ProductRequest product){
        return productService.saveProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Integer id,
                                 @RequestBody ProductRequest productRequest){
        return productService.updateProduct(id,productRequest);
    }

    @DeleteMapping("/products/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable("id") Integer id){
        productService.deleteProductById(id);
    }

}
