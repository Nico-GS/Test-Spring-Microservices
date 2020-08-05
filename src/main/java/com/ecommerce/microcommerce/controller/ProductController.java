package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

//    // Récupère la liste des produits
//    @RequestMapping(value = "/Produits", method = RequestMethod.GET)
//    public List<Product> listProduits() {
//        return productDao.findAll ();
//    }
//
//    // Récupère un produit par son ID
//    @GetMapping(value = "/Produits/{id}")
//    public Product afficherUnProduit (@PathVariable int id) {
//        return productDao.findById (id);
//    }

    // Produits
    @GetMapping(value = "Produits")
    public List<Product> listeProduits() {
        return productDao.findAll ();
    }

    // Récupère un produit par son ID
    @GetMapping(value = "/Produits/{id}")
    public Product afficherUnProduit (@PathVariable int id) {
        return productDao.findById (id);
    }


    
}
