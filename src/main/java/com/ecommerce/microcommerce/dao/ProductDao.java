package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;

import java.util.List;

public interface ProductDao {

    // Liste des opérations disponibles
     List<Product> findAll();
     Product findById(int id);
     Product save(Product product);
}
