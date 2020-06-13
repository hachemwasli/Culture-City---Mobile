/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Entity;

/**
 *
 * @author user
 */
public class User {
    
    private int id;
    private String userName;
    private String email;
    private String password;
    private String roles;
    private String nom;
    private String prenom;
    private String image;

    public User(int id, String userName, String email, String password, String nom, String prenom, String image) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
    }

    public User(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    
    public User(int id, String userName, String email, String password,String roles,String nom, String prenom, String image) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.password=password;
        this.roles=roles;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
    }

    public User() {
    }

    public User(String userName, String image) {
        this.userName = userName;
        this.image = image;
    }

    public User(String userName, String email, String password, String nom, String prenom,String image) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.image=image;
    }
    
    

    public User(String userName, String email, String password,String roles, String nom, String prenom, String image) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.roles=roles;
        this.nom = nom;
        this.prenom = prenom;
        this.image = image;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
    
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + ", roles=" + roles + ", nom=" + nom + ", prenom=" + prenom + ", image=" + image + '}';
    }

    
  
    
    
    
    
}
