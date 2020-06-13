/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.mycompany.Entity.*;
import java.util.Date;

/**
 *
 * @author HP
 */
public class fos_user {
    int id ;
    String username ;
    String username_canonical ;
    String email ;
    String email_canonical ;
    int enabled ;
    String salt ;
    String password ;
    Date last_login ;
    String confirmation_token ;
    Date password_requested_at ;
    String roles ;
    String name ;
    String last_name; 
    Date birth_date ;
    String bio ;
    String location ;
    Date register_date ;
    float earnings ;
    float expenses ;
    float budget ;
    String field_company ;

    public fos_user() {
    }
    public fos_user(String username,String email) {
        this.username=username;
        this.email=email;
    }
     public fos_user(String username,String email,String name) {
        this.username=username;
        this.email=email;
        this.username=name;
    }

    public fos_user(int id, String username, String username_canonical, String email, String email_canonical,
            int enabled, String salt, String password, Date last_login, String confirmation_token, Date password_requested_at,
            String roles, String name, String last_name, Date birth_date, String bio, String location, Date register_date, float earnings, float expenses, float budget, String field_company) {
        this.id = id;
        this.username = username;
        this.username_canonical = username_canonical;
        this.email = email;
        this.email_canonical = email_canonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.last_login = last_login;
        this.confirmation_token = confirmation_token;
        this.password_requested_at = password_requested_at;
        this.roles = roles;
        this.name = name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.bio = bio;
        this.location = location;
        this.register_date = register_date;
        this.earnings = earnings;
        this.expenses = expenses;
        this.budget = budget;
        this.field_company = field_company;
    }

    
    
    public String getBio() {
        return bio;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public float getBudget() {
        return budget;
    }

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public float getEarnings() {
        return earnings;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail_canonical() {
        return email_canonical;
    }

    public int getEnabled() {
        return enabled;
    }

    public float getExpenses() {
        return expenses;
    }

    public String getField_company() {
        return field_company;
    }

    public int getId() {
        return id;
    }

    public Date getLast_login() {
        return last_login;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Date getPassword_requested_at() {
        return password_requested_at;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public String getRoles() {
        return roles;
    }

    public String getSalt() {
        return salt;
    }

    public String getUsername() {
        return username;
    }

    public String getUsername_canonical() {
        return username_canonical;
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }


    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public void setEarnings(float earnings) {
        this.earnings = earnings;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEmail_canonical(String email_canonical) {
        this.email_canonical = email_canonical;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public void setExpenses(float expenses) {
        this.expenses = expenses;
    }

    public void setField_company(String field_company) {
        this.field_company = field_company;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPassword_requested_at(Date password_requested_at) {
        this.password_requested_at = password_requested_at;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUsername_canonical(String username_canonical) {
        this.username_canonical = username_canonical;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

 

   
    
    
    
}
