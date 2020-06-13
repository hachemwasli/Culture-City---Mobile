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
public class Club {
    private int idClub;
    private String nomClub;
    private String descriptionClub;
    private String logoClub;
    private int idCategoriec;
    private int nbrParticipants;

    public Club(int idClub, String nomClub, String descriptionClub, String logoClub, int idCategoriec, int nbrParticipants) {
        this.idClub = idClub;
        this.nomClub = nomClub;
        this.descriptionClub = descriptionClub;
        this.logoClub = logoClub;
        this.idCategoriec = idCategoriec;
        this.nbrParticipants = nbrParticipants;
    }

    public Club() {
    }

    public int getIdClub() {
        return idClub;
    }

    public String getNomClub() {
        return nomClub;
    }

    public String getDescriptionClub() {
        return descriptionClub;
    }

    public String getLogoClub() {
        return logoClub;
    }

    public int getIdCategoriec() {
        return idCategoriec;
    }

    public int getNbrParticipants() {
        return nbrParticipants;
    }

    public void setIdClub(int idClub) {
        this.idClub = idClub;
    }

    public void setNomClub(String nomClub) {
        this.nomClub = nomClub;
    }

    public void setDescriptionClub(String descriptionClub) {
        this.descriptionClub = descriptionClub;
    }

    public void setLogoClub(String logoClub) {
        this.logoClub = logoClub;
    }

    public void setIdCategoriec(int idCategoriec) {
        this.idCategoriec = idCategoriec;
    }

    public void setNbrParticipants(int nbrParticipants) {
        this.nbrParticipants = nbrParticipants;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Club other = (Club) obj;
        if (this.idClub != other.idClub) {
            return false;
        }
        if (this.idCategoriec != other.idCategoriec) {
            return false;
        }
        if (this.nbrParticipants != other.nbrParticipants) {
            return false;
        }
        if (!Objects.equals(this.nomClub, other.nomClub)) {
            return false;
        }
        if (!Objects.equals(this.descriptionClub, other.descriptionClub)) {
            return false;
        }
        if (!Objects.equals(this.logoClub, other.logoClub)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Club{" + "idClub=" + idClub + ", nomClub=" + nomClub + ", descriptionClub=" + descriptionClub + ", logoClub=" + logoClub + ", idCategoriec=" + idCategoriec + ", nbrParticipants=" + nbrParticipants + '}';
    }

    public Club(int idClub, String nomClub, String descriptionClub, String logoClub, int nbrParticipants) {
        this.idClub = idClub;
        this.nomClub = nomClub;
        this.descriptionClub = descriptionClub;
        this.logoClub = logoClub;
        this.nbrParticipants = nbrParticipants;
    }
    
    
    
}

