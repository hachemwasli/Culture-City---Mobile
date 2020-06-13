/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Objects;

/**
 *
 * @author Mnif
 */
public class Film {
    
    private int id_film;
    private String nom_film;
    private String description_film;
    private String categorie_film;
    private String image_film;

    public Film() {
    }

    public Film(int id_film, String nom_film, String description_film, String categorie_film, String image_film) {
        this.id_film = id_film;
        this.nom_film = nom_film;
        this.description_film = description_film;
        this.categorie_film = categorie_film;
        this.image_film = image_film;
    }

    public Film(String nom_film, String description_film, String categorie_film, String image_film) {
        this.nom_film = nom_film;
        this.description_film = description_film;
        this.categorie_film = categorie_film;
        this.image_film = image_film;
    }

    public int getId_film() {
        return id_film;
    }

    public String getNom_film() {
        return nom_film;
    }

    public String getDescription_film() {
        return description_film;
    }

    public String getCategorie_film() {
        return categorie_film;
    }

    public String getImage_film() {
        return image_film;
    }

    public void setId_film(int id_film) {
        this.id_film = id_film;
    }

    public void setNom_film(String nom_film) {
        this.nom_film = nom_film;
    }

    public void setDescription_film(String description_film) {
        this.description_film = description_film;
    }

    public void setCategorie_film(String categorie_film) {
        this.categorie_film = categorie_film;
    }

    public void setImage_film(String image_film) {
        this.image_film = image_film;
    }

    @Override
    public String toString() {
        return "Film{" + "id_film=" + id_film + ", nom_film=" + nom_film + ", description_film=" + description_film + ", categorie_film=" + categorie_film + ", image_film=" + image_film + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.id_film;
        hash = 17 * hash + Objects.hashCode(this.nom_film);
        hash = 17 * hash + Objects.hashCode(this.description_film);
        hash = 17 * hash + Objects.hashCode(this.categorie_film);
        hash = 17 * hash + Objects.hashCode(this.image_film);
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
        final Film other = (Film) obj;
        if (this.id_film != other.id_film) {
            return false;
        }
        if (!Objects.equals(this.nom_film, other.nom_film)) {
            return false;
        }
        if (!Objects.equals(this.description_film, other.description_film)) {
            return false;
        }
        if (!Objects.equals(this.categorie_film, other.categorie_film)) {
            return false;
        }
        if (!Objects.equals(this.image_film, other.image_film)) {
            return false;
        }
        return true;
    }
    
    
    
}
