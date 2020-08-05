package com.ecommerce.microcommerce.model;

// AUSSI APPELÉ BEAN OU JAVABEAN

public class Product {

    private int id;
    private String nom;
    private int prix;
    private int dureeDeVie;

    public Product (int id, String nom, int prix, int dureeDeVie) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.dureeDeVie = dureeDeVie;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getNom () {
        return nom;
    }

    public void setNom (String nom) {
        this.nom = nom;
    }

    public int getPrix () {
        return prix;
    }

    public void setPrix (int prix) {
        this.prix = prix;
    }

    public int getDureeDeVie () {
        return dureeDeVie;
    }

    public void setDureeDeVie (int dureeDeVie) {
        this.dureeDeVie = dureeDeVie;
    }

    @Override
    public String toString () {
        return "Product{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", dureeDeVie=" + dureeDeVie +
                '}';
    }
}
