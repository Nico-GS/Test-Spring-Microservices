package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;

import java.util.List;

public interface ProductDao {

    // Liste des opérations disponibles
    public List<Product> findAll();
    public Product findById(int id);
    public Product save(Product product);
}
