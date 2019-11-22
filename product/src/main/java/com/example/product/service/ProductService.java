package com.example.product.service;

import com.example.product.model.Items;
import com.example.product.repositories.ProductRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ProductService {
    ProductRepositories productRepositories ;

    @Autowired
    public ProductService(ProductRepositories productRepositories) {
        this.productRepositories = productRepositories;
    }

    public Items getProductById(Long id) {
        return productRepositories.findAllById(id) ;
    }

    public List<Items> getProduct() {
        return productRepositories.findAll() ;
    }

    public Items createProduct(Items body) {
        return productRepositories.save(body) ;
    }

    public Items updateProduct(Long id,Items items) {
        return productRepositories.findAllById(id) != null ?
                productRepositories.save(items) : productRepositories.findAllById(id) ;
    }

}

