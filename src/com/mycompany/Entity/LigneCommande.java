/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entity;
import com.mycompany.Entity.Article;

/**
 *
 * @author PC
 */
public class LigneCommande {
        private int idpanier;
        private int quantitepanier;
        private Article idarticle;
        private int  iduser;
        private String nomart;
        private int prix;
        private int Total;

    public LigneCommande(int idpanier, int quantitepanier, Article idarticle, int iduser) {
        this.idpanier = idpanier;
        this.quantitepanier = quantitepanier;
        this.idarticle = idarticle;
        this.iduser = iduser;
    }

    public LigneCommande() {
    }

    public LigneCommande(int quantitepanier, Article idarticle, int iduser) {
        this.quantitepanier = quantitepanier;
        this.idarticle = idarticle;
        this.iduser = iduser;
    }

    public int getIdpanier() {
        return idpanier;
    }

    public void setIdpanier(int idpanier) {
        this.idpanier = idpanier;
    }

    public int getQuantitepanier() {
        return quantitepanier;
    }

    public void setQuantitepanier(int quantitepanier) {
        this.quantitepanier = quantitepanier;
    }

    public Article getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(Article idarticle) {
        this.idarticle = idarticle;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public String getNomart() {
        return nomart;
    }

    public void setNomart(String nomart) {
        this.nomart = nomart;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int Total) {
        this.Total = Total;
    }
    
        
    
}
