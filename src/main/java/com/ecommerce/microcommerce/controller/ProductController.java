package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ProductController {

    Logger logger;

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
    @GetMapping(value = "/Produits")
    public List<Product> listeProduits() {
        return productDao.findAll ();
    }

    // Récupère un produit par son ID
    @GetMapping(value = "/Produits/{id}")
    public Product afficherUnProduit (@PathVariable int id) {
        return productDao.findById (id);
    }

    @PostMapping(value = "/Produits/")
    public void ajouterProduit(@RequestBody Product product, HttpServletRequest request) {
        productDao.save (product);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(HttpMessageNotReadableException e) {
        logger.warn ("Returning HTTP 400 Bad Request", e);
    }


    
}
