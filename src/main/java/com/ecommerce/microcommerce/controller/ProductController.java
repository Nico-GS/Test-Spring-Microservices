package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private Logger logger;

    @Autowired
    private ProductDao productDao;

    // Produits
    @RequestMapping(value = "/Produits", method = RequestMethod.GET)
    public MappingJacksonValue listeProduits() {
        Iterable<Product> produits = productDao.findAll ();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept ("prixAchat");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider()
                .addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue produitsFiltres = new MappingJacksonValue(produits);
        produitsFiltres.setFilters(listDeNosFiltres);
        return produitsFiltres;
    }

    // Récupère un produit par son ID
//    @GetMapping(value = "/Produits/{id}")
//    public Product afficherUnProduit(@PathVariable int id) {
//        return productDao.findById (id);
//    }
//
//    @PostMapping(value = "/Produits")
//    public ResponseEntity<Void> ajouterProduit(@RequestBody Product product) {
//
//        Product product1 = productDao.save(product);
//
//        if (product == null) {
//            return ResponseEntity.noContent ().build ();
//        }
//
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest ().path ("/{id}")
//                .buildAndExpand (product1.getId ()).toUri ();
//        return ResponseEntity.created (location).build ();
//    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(final HttpMessageNotReadableException e) {
        logger.warn("Returning HTTP 400 Bad Request", e);
    }
}
