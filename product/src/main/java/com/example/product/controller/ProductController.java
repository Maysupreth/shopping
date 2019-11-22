package com.example.product.controller;

import com.example.product.model.Items;
import com.example.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
@Slf4j

public class ProductController {
    private ProductService productService ;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping("list")
    public List<Items> getAllProduct(){
        return productService.getProduct() ;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String test(){
        return "Hello World" ;
    }

    @RequestMapping(path = "/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id ) {
        Items items = productService.getProductById(id) ;
        return items != null ? ResponseEntity.ok(items) : ResponseEntity.notFound().build() ;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/create")
    public ResponseEntity<?> createProduct(@Valid @RequestBody Items body){
        Items items = productService.createProduct(body) ;
        return ResponseEntity.status(HttpStatus.CREATED).body(items) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putProduct(@PathVariable Long id,@Valid @RequestBody Items body){
        body.setId(id);
        Items items = productService.updateProduct(id,body) ;
        return items !=null ? ResponseEntity.ok(items) : ResponseEntity.notFound().build() ;
    }
}
