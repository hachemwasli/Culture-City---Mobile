/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.mycompany.GUI.*;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entity.Article;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public class ListArticleService {
       public ArrayList<Article> parseListTaskJson(String json) {

        ArrayList<Article> listProduits = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();// Instanciation d'un objet JSONParser permettant le parsing du résultat json

            /*
                On doit convertir notre réponse texte en CharArray à fin de
            permettre au JSONParser de la lire et la manipuler d'ou vient 
            l'utilité de new CharArrayReader(json.toCharArray())
            
            La méthode parse json retourne une MAP<String,Object> ou String est 
            la clé principale de notre résultat.
            Dans notre cas la clé principale n'est pas définie cela ne veux pas
            dire qu'elle est manquante mais plutôt gardée à la valeur par defaut
            qui est root.
            En fait c'est la clé de l'objet qui englobe la totalité des objets 
                    c'est la clé définissant le tableau de tâches.
            */
            Map<String, Object> produits= j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
               Article p = new Article();

                float id = Float.parseFloat(obj.get("idarticle").toString());

                p.setIdarticle((int) id);
                p.setNomarticle(obj.get("nomarticle").toString());
                 p.setImagearticle(obj.get("imagearticle").toString());
                float qauntite = Float.parseFloat(obj.get("quantitearticle").toString());
                p.setQuantitearticles((int) qauntite);
                float prixProd = Float.parseFloat(obj.get("prixarticle").toString());
                p.setPrixarticle((int) prixProd);
               
                System.out.println(p);
                
                listProduits.add(p);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listProduits);

        return listProduits;
    }
    
    
    ArrayList<Article> listProduits = new ArrayList<>();
    
    public ArrayList<Article> getList2(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/vente/allArticle");  
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ListArticleService ser = new ListArticleService();
                listProduits = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listProduits;
    }
       ArrayList<Article> listartart = new ArrayList<>();
    
    public ArrayList<Article> getListArtisnata(){       
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/vente/Artisanat");  
        con.setPost(false);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ListArticleService ser = new ListArticleService();
                listartart = ser.parseListTaskJson(new String(con.getResponseData()));
                System.out.println(listartart);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listartart;
    }
}
