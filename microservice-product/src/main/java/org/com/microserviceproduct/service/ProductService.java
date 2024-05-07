package org.com.microserviceproduct.service;

import lombok.AllArgsConstructor;
import org.com.microserviceproduct.dtos.ProductRequest;
import org.com.microserviceproduct.entities.Product;
import org.com.microserviceproduct.exceptions.ProductNotFoundException;
import org.com.microserviceproduct.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private final ModelMapper modelMapper=new ModelMapper();

    public List<Product> findAllProducts(){

        List<Product> products=productRepository.findAll();
        if(products.isEmpty()) throw new ProductNotFoundException();
        return products;
    }

    public Product findProductById(Integer id){
        return productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
    }

    public Product saveProduct(ProductRequest productRequest){
        Product product=modelMapper.map(productRequest,Product.class);
        return productRepository.save(product);
    }

    public Product updateProduct(Integer id, ProductRequest productRequest){
        Product existingProduct=findProductById(id);
        modelMapper.map(productRequest,existingProduct);
        return productRepository.save(existingProduct);
    }

    public void deleteProductById(Integer id){
        Product product=findProductById(id);
        productRepository.delete(product);
    }
}
