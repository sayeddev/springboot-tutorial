package com.sayedLabs.spring.springboot.controller;

import com.sayedLabs.spring.springboot.SpringbootApplication;
import com.sayedLabs.spring.springboot.exception.ProductNotFoundException;
import com.sayedLabs.spring.springboot.model.Product;
import com.sayedLabs.spring.springboot.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(SpringbootApplication.class);

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:8080")
    public ResponseEntity<Object> getProducts() {
        logger.info("Testing get product");
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return new ResponseEntity<>("Product is added successfully",HttpStatus.CREATED);
    }


    @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProduct(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return  new ResponseEntity<>("Product is deleted Successfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateProduct(@PathVariable Integer id, @RequestBody Product product) {
        productService.updateProduct(id, product);
        return new ResponseEntity<>("Product is updated Successfully", HttpStatus.OK);
    }
}
