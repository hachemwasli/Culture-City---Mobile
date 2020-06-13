


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkManager;
import com.mycompany.Entity.User;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class UserService {
    public static UserService instance;
      private User user;
      
        public UserService(){}
    
    public static UserService getInstance(){
        if(instance == null)
            instance = new UserService();
        return instance;
    }
      
    public void Inscription(User u) {
        ConnectionRequest con = new ConnectionRequest();
       
        
        String Url = "http://localhost/codetest/web/app_dev.php/user/inscription/" + u.getUserName() + 
                "/" + u.getEmail() + "/" + u.getPassword();
        con.setUrl(Url);
            
     

        con.addResponseListener((l) -> {
            String str = new String(con.getResponseData());
            

        });
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
     
    public User getUser(int id){
        ConnectionRequest con = new ConnectionRequest();
        String url ="http://localhost/codetest/web/app_dev.php/user/getUser/"+id; // ""+id;
        con.setUrl(url);
        con.addResponseListener((e) -> {
            UserService us = new UserService();
            String str = new String(con.getResponseData());
            user = us.parseeUser(str);
        });
        con.addExceptionListener((ev) -> {
            user = null;
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return user;
    }
      
      public User getU(String username){
        
        ConnectionRequest con = new ConnectionRequest();
        String url = "http://localhost/codetest/web/app_dev.php/user/getU/"+username;
        con.setUrl(url);
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            user = parseUser(str);
        });
        con.addExceptionListener((ev) -> {
            user = null;
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
          
        return user;
    }
      
       private User parseeUser(String json){
       User m = new User();  
     try {
            JSONParser j = new JSONParser();
            Map<String, Object> Evennements = j.parseJSON(new CharArrayReader(json.toCharArray()));
         
                 
                m.setId(((Double) Evennements.get("id")).intValue());
                 
                 
                m.setUserName((String)Evennements.get("username"));
               
            
        } catch (Exception ex) {
            System.out.println("err");
        }
        return m;
    } 
       
      private User parseUser(String json){
      User m = new User();
     
     
     
     try {
            JSONParser j = new JSONParser();
            Map<String, Object> Evennements = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) Evennements.get("root");
            for (Map<String, Object> obj : list) {
                float id = Float.parseFloat(obj.get("id").toString());
                m.setId(((Double) obj.get("id")).intValue());
                m.setUserName((String)obj.get("username"));
                m.setEmail((String)obj.get("email"));
                m.setPassword((String)obj.get("password"));
                m.setNom((String)obj.get("nom"));
                m.setPrenom((String) obj.get("prenom"));
                m.setImage((String)obj.get("image"));
            }
        } catch (Exception ex) {
            System.out.println("lol");
        }
        return m;
    }
      
      public User editUser(User u){
        ConnectionRequest con = new ConnectionRequest();
         
        String url = "http://localhost/codetest/web/app_dev.php/user/edit/"+u.getId();
          System.out.println(u.getId());
        con.setUrl(url);
        con.setPost(true);
        
        
        con.addArgument("username", u.getUserName());
        con.addArgument("email", u.getEmail());
        con.addArgument("password", u.getPassword());
      
        con.addArgument("nom", u.getNom());
        con.addArgument("prenom", u.getPrenom());
        con.addArgument("image", u.getImage());
       
        con.addResponseListener((e) -> {
            String str = new String(con.getResponseData());
            user = getUser(u.getId());
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
      
        return user;
          
    }
         
}
