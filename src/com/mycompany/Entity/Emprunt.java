/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entity;

import com.codename1.ui.spinner.Picker;







/**
 *
 * @author ASUS X541UJ
 */
public class Emprunt {
    private int id ;
    private String id_utilisateur;
    private String id_livre;
    private String date_debut;
    private String date_retour;
    private String nom;
    private String title;

    public Emprunt() {
    }

    public Emprunt(int id, String id_utilisateur, String id_livre, String date_debut, String date_retour) {
        this.id = id;
        this.id_utilisateur = id_utilisateur;
        this.id_livre = id_livre;
       
     
        
       
  
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getId_utilisateur() {
        return id_utilisateur;
    }

    public String getId_livre() {
        return id_livre;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public String getDate_retour() {
        return date_retour;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_utilisateur(String id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public void setId_livre(String id_livre) {
        this.id_livre = id_livre;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_retour(String date_retour) {
        this.date_retour = date_retour;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
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
        final Emprunt other = (Emprunt) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Emprunt{" + "id=" + id + ", id_utilisateur=" + id_utilisateur + ", id_livre=" + id_livre + ", date_debut=" + date_debut + ", date_retour=" + date_retour + ", nom=" + nom + ", title=" + title + '}';
    }

   

 
    

}
