/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entity;

import java.util.Date;

/**
 *
 * @author Zliaa
 */
public class Evennement {
    
    private int id; 	 
    private String description;	
    private Date dtDebut;	
    private Date dtFin;	
    private int nbPlace;	
    private String entree;
    private float  prix ;
    private Date dateCreation ;
    private TypeEvennement type;  
    private String image;

    public Evennement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDtDebut() {
        return dtDebut;
    }

    public void setDtDebut(Date dtDebut) {
        this.dtDebut = dtDebut;
    }

    public Date getDtFin() {
        return dtFin;
    }

    public void setDtFin(Date dtFin) {
        this.dtFin = dtFin;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public TypeEvennement getType() {
        return type;
    }

    public void setType(TypeEvennement type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Evennement{" + "id=" + id + ", description=" + description + ", dtDebut=" + dtDebut + ", dtFin=" + dtFin + ", nbPlace=" + nbPlace + ", entree=" + entree + ", prix=" + prix + ", dateCreation=" + dateCreation + ", type=" + type + ", image=" + image + '}';
    }
    
    
}
