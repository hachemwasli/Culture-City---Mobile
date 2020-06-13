/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entity;

import java.util.Objects;

/**
 *
 * @author yassmine
 */
public class CategorieC {
     private int idCategoriec;
     private String nomCategoriec;

    public CategorieC(int idCategoriec) {
        this.idCategoriec = idCategoriec;
    }

    public CategorieC(int idCategoriec, String nomCategoriec) {
        this.idCategoriec = idCategoriec;
        this.nomCategoriec = nomCategoriec;
    }

    public CategorieC() {
    }

    public int getIdCategoriec() {
        return idCategoriec;
    }

    public String getNomCategoriec() {
        return nomCategoriec;
    }

    public void setIdCategoriec(int idCategoriec) {
        this.idCategoriec = idCategoriec;
    }

    public void setNomCategoriec(String nomCategoriec) {
        this.nomCategoriec = nomCategoriec;
    }

    @Override
    public String toString() {
        return "CategorieC{" + "idCategoriec=" + idCategoriec + ", nomCategoriec=" + nomCategoriec + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final CategorieC other = (CategorieC) obj;
        if (this.idCategoriec != other.idCategoriec) {
            return false;
        }
        if (!Objects.equals(this.nomCategoriec, other.nomCategoriec)) {
            return false;
        }
        return true;
    }
     
    
}
