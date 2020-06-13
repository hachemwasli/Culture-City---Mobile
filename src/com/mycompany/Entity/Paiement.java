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
public class Paiement {
  private  String carte;
  private String mdp;
  private double Total;

    public Paiement(String carte, String mdp, double Total) {
        this.carte = carte;
        this.mdp = mdp;
        this.Total = Total;
    }

    public String getCarte() {
        return carte;
    }

    public void setCarte(String carte) {
        this.carte = carte;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    @Override
    public String toString() {
        return "Paiement{" + "carte=" + carte + ", mdp=" + mdp + ", Total=" + Total + '}';
    }

    public Paiement() {
    }
  
    
}
