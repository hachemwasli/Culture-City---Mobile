/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entity;

/**
 *
 * @author Zliaa
 */
public class TypeEvennement {
   private  int id ; 
    private String libele ; 
    private String Description ;
    

    public TypeEvennement() {
    }

    public TypeEvennement(int id, String libele, String Description) {
        this.id = id;
        this.libele = libele;
        this.Description = Description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return "Evennement{" + "id=" + id + ", libele=" + libele + ", Description=" + Description + '}';
    }
    
        
}
