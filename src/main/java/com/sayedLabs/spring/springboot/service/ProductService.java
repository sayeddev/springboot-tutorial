package com.sayedLabs.spring.springboot.service;

import com.sayedLabs.spring.springboot.model.Product;

import java.util.List;

public interface ProductService {
    public void addProduct(Product product);

    public void updateProduct(int id, Product product);

    public List<Product> getProducts();

    public void deleteProduct(int id);
}
