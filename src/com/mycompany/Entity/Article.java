/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entity;

/**
 *
 * @author PC
 */
public class Article {
    private int idarticle;
    private String nomarticle;
    private int prixarticle;
    private int quantitearticles;
    private String imagearticle;

    public Article(int idarticle, String nomarticle, int prixarticle, int quantitearticles, String imagearticle) {
        this.idarticle = idarticle;
        this.nomarticle = nomarticle;
        this.prixarticle = prixarticle;
        this.quantitearticles = quantitearticles;
        this.imagearticle = imagearticle;
    }

    public Article(String nomarticle, int prixarticle, int quantitearticles, String imagearticle) {
        this.nomarticle = nomarticle;
        this.prixarticle = prixarticle;
        this.quantitearticles = quantitearticles;
        this.imagearticle = imagearticle;
    }

    public Article() {
    }

    public int getIdarticle() {
        return idarticle;
    }

    public void setIdarticle(int idarticle) {
        this.idarticle = idarticle;
    }

    public String getNomarticle() {
        return nomarticle;
    }

    public void setNomarticle(String nomarticle) {
        this.nomarticle = nomarticle;
    }

    public int getPrixarticle() {
        return prixarticle;
    }

    public void setPrixarticle(int prixarticle) {
        this.prixarticle = prixarticle;
    }

    public int getQuantitearticles() {
        return quantitearticles;
    }

    public void setQuantitearticles(int quantitearticles) {
        this.quantitearticles = quantitearticles;
    }

    public String getImagearticle() {
        return imagearticle;
    }

    public void setImagearticle(String imagearticle) {
        this.imagearticle = imagearticle;
    }

    @Override
    public String toString() {
        return "Article{" + "idarticle=" + idarticle + ", nomarticle=" + nomarticle + ", prixarticle=" + prixarticle + ", quantitearticles=" + quantitearticles + ", imagearticle=" + imagearticle + '}';
    }
    
    
    
}
