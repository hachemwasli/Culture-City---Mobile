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
public class Salle {
    
    private int numero_salle;
    private int nombrePlace_salle;
    private String nom_salle;

    public Salle() {
    }

    public Salle(int numero_salle, int nombrePlace_salle, String nom_salle) {
        this.numero_salle = numero_salle;
        this.nombrePlace_salle = nombrePlace_salle;
        this.nom_salle = nom_salle;
    }

    public Salle(int nombrePlace_salle, String nom_salle) {
        this.nombrePlace_salle = nombrePlace_salle;
        this.nom_salle = nom_salle;
    }

    public int getNumero_salle() {
        return numero_salle;
    }

    public int getNombrePlace_salle() {
        return nombrePlace_salle;
    }

    public String getNom_salle() {
        return nom_salle;
    }

    public void setNumero_salle(int numero_salle) {
        this.numero_salle = numero_salle;
    }

    public void setNombrePlace_salle(int nombrePlace_salle) {
        this.nombrePlace_salle = nombrePlace_salle;
    }

    public void setNom_salle(String nom_salle) {
        this.nom_salle = nom_salle;
    }

    @Override
    public String toString() {
        return "Salle{" + "numero_salle=" + numero_salle + ", nombrePlace_salle=" + nombrePlace_salle + ", nom_salle=" + nom_salle + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.numero_salle;
        hash = 47 * hash + this.nombrePlace_salle;
        hash = 47 * hash + Objects.hashCode(this.nom_salle);
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
        final Salle other = (Salle) obj;
        if (this.numero_salle != other.numero_salle) {
            return false;
        }
        if (this.nombrePlace_salle != other.nombrePlace_salle) {
            return false;
        }
        if (!Objects.equals(this.nom_salle, other.nom_salle)) {
            return false;
        }
        return true;
    }
    
    
    
}
