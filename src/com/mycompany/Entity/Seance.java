/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entite;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Mnif
 */
public class Seance {
    
    private int id_seance;
    private String film;
    private String salle;
    private Date date_seance;

    public Seance() {
    }

    public Seance(int id_seance, String film, String salle, Date date_seance) {
        this.id_seance = id_seance;
        this.film = film;
        this.salle = salle;
        this.date_seance = date_seance;
    }

    public Seance(String film, String salle, Date date_seance) {
        this.film = film;
        this.salle = salle;
        this.date_seance = date_seance;
    }

    public int getId_seance() {
        return id_seance;
    }

    public String getFilm() {
        return film;
    }

    public String getSalle() {
        return salle;
    }

    public Date getDate_seance() {
        return date_seance;
    }

    public void setId_seance(int id_seance) {
        this.id_seance = id_seance;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public void setDate_seance(Date date_seance) {
        this.date_seance = date_seance;
    }

    @Override
    public String toString() {
        return "Seance{" + "id_seance=" + id_seance + ", film=" + film + ", salle=" + salle + ", date_seance=" + date_seance + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + this.id_seance;
        hash = 17 * hash + Objects.hashCode(this.film);
        hash = 17 * hash + Objects.hashCode(this.salle);
        hash = 17 * hash + Objects.hashCode(this.date_seance);
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
        final Seance other = (Seance) obj;
        if (this.id_seance != other.id_seance) {
            return false;
        }
        if (!Objects.equals(this.film, other.film)) {
            return false;
        }
        if (!Objects.equals(this.salle, other.salle)) {
            return false;
        }
        if (!Objects.equals(this.date_seance, other.date_seance)) {
            return false;
        }
        return true;
    }
    
    
    
}
