/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entity;

import java.util.Objects;

/**
 *
 * @author ASUS X541UJ
 */
public class Livre {


    
    private int idL;
    private String titreL;
    private String dateEdition;
    private String auteur;
    private String copie_dispo;
    private String idCL;
    private String genre; 
    private String img;
    
public Livre() {
    }

    public Livre(int idL, String titreL, String dateEdition, String auteur, String copie_dispo, String idCL, String genre, String img) {
        this.idL = idL;
        this.titreL = titreL;
        this.dateEdition = dateEdition;
        this.auteur = auteur;
        this.copie_dispo = copie_dispo;
        this.idCL = idCL;
        this.genre = genre;
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

   

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getIdL() {
        return idL;
    }

    public String getTitreL() {
        return titreL;
    }

    public String getDateEdition() {
        return dateEdition;
    }

    public String getAuteur() {
        return auteur;
    }

    public String getCopie_dispo() {
        return copie_dispo;
    }

    public String getIdCL() {
        return idCL;
    }

    public void setIdL(int idL) {
        this.idL = idL;
    }

    public void setTitreL(String titreL) {
        this.titreL = titreL;
    }

    public void setDateEdition(String dateEdition) {
        this.dateEdition = dateEdition;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void setCopie_dispo(String copie_dispo) {
        this.copie_dispo = copie_dispo;
    }

    public void setIdCL(String idCL) {
        this.idCL = idCL;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.idL;
        hash = 67 * hash + Objects.hashCode(this.titreL);
        hash = 67 * hash + Objects.hashCode(this.dateEdition);
        hash = 67 * hash + Objects.hashCode(this.auteur);
      
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Livre other = (Livre) obj;
        if (this.idL != other.idL) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Livre{" + "idL=" + idL + ", titreL=" + titreL + ", dateEdition=" + dateEdition + ", auteur=" + auteur + ", copie_dispo=" + copie_dispo + ", idCL=" + idCL + ", genre=" + genre + ", img=" + img + '}';
    }

  



   
}

