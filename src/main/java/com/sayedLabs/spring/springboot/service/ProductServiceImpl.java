package com.sayedLabs.spring.springboot.service;

import com.sayedLabs.spring.springboot.exception.ProductNotFoundException;
import com.sayedLabs.spring.springboot.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private static List<Product> products = new ArrayList<Product>();
    static {
        Product product1 = new Product();
        product1.setId(1);
        product1.setName("Sayed");

        products.add(product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setName("Adam");

        products.add(product2);
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        if (!products.contains(product)) {
            throw new ProductNotFoundException();
        }
        products.remove(product);
        products.add(product);
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public void deleteProduct(int id) {
        for (Product product: products) {
            if (product.getId() == id) {
                products.remove(product);
                return;
            }
        }
        throw  new ProductNotFoundException();
    }
}
