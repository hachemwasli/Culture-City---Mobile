/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entity;

/**
 *
 * @author ASUS X541UJ
 */
public class CategorieL {
    private int id_catL;
    private String genre;
    private String description;

    public CategorieL() {
    }

    public CategorieL(int id_catL, String genre, String description) {
        this.id_catL = id_catL;
        this.genre = genre;
        this.description = description;
    }

    public int getId_catL() {
        return id_catL;
    }

    public void setId_catL(int id_catL) {
        this.id_catL = id_catL;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id_catL;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategorieL other = (CategorieL) obj;
        if (this.id_catL != other.id_catL) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CategorieL{" + "id_catL=" + id_catL + ", genre=" + genre + ", description=" + description + '}';
    }

  
}
