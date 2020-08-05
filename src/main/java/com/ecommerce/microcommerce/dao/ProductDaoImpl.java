package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{

    public static List<Product> products = new ArrayList<>();

    static {
        products.add (new Product (1, "Ordinateur portable", 350, 10));
        products.add (new Product (2, "Aspirateur Robot", 500, 5));
        products.add (new Product (3, "Table de Ping-Pong", 700, 20));
        products.add (new Product (4, "Console", 399, 5));
    }

    @Override
    public List<Product> findAll () {
        return products;
    }

    @Override
    public Product findById (int id) {
        return null;
    }

    @Override
    public Product save (Product product) {
        return null;
    }
}
