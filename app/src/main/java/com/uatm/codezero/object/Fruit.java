package com.uatm.codezero.object;

import java.io.Serializable;

public class Fruit implements Serializable {
    int imageLink;
    String nom;

    String bien_fait;

    public Fruit(int imageLink, String nom, String bien_fait) {
        this.imageLink = imageLink;
        this.nom = nom;
        this.bien_fait = bien_fait;
    }

    public int getImageLink() {

        return imageLink;
    }

    public void setImageLink(int imageLink) {
        this.imageLink = imageLink;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getBien_fait() {
        return bien_fait;
    }

    public void setBien_fait(String bien_fait) {
        this.bien_fait = bien_fait;
    }
}
