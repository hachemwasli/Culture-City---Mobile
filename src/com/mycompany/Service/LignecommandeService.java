/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.Entity.Article;
import com.mycompany.Entity.LigneCommande;
import com.mycompany.Entity.User;
import com.mycompany.GUI.Login;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author PC
 */
public class LignecommandeService {
      private String retour; 
      User u = new User();
    
    ArrayList<LigneCommande> listLigneCommande;
ArrayList<Article> listProduit;
 
    public void ajouterlc(LigneCommande L) {
        u =Login.hama;
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/codetest/web/app_dev.php/vente/" + 2+ "/" + L.getIdarticle().getIdarticle()+ "/" + L.getQuantitepanier();
        con.setUrl(Url);
        NetworkManager.getInstance().addToQueueAndWait(con);
    }
      public void supplc(LigneCommande L) {
        ConnectionRequest con = new ConnectionRequest();
        String Url = "http://localhost/codetest/web/app_dev.php/vente/SuppLC/"+L.getIdpanier();
        con.setUrl(Url); 
       NetworkManager.getInstance().addToQueueAndWait(con);
    }
      
     public ArrayList<LigneCommande> getList2() {
        listLigneCommande = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/vente/indexpanier/"+2);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    System.out.println(u.getId());
                    //listTasks = getListTask(new String(con.getResponseData()));
                    JSONParser jsonp = new JSONParser();

                    System.out.println("Contenu d panier");
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> lignecommande = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" + lignecommande.get("root"));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) lignecommande.get("root");
                    System.out.println("ttt");
                    for (Map<String, Object> obj : list) {
                        System.out.println("ppp");
                        LigneCommande lc = new LigneCommande();
                      int id = (int) Float.parseFloat(obj.get("idLignecommande").toString());
                        // int iduser = (int) Float.parseFloat(obj.get("iduser").toString());
                        int quantite = (int) Float.parseFloat(obj.get("quantite").toString());
                        //int article =(int) Float.parseFloat(obj.get("idarticle").toString());
                           Map<String, Object> data1 = (Map<String, Object>) (obj.get("idarticle"));
                            System.out.println(data1);
                            String n=data1.get("nomarticle").toString();
                            String p=data1.get("prixarticle").toString();
                              System.out.println(n);
                           lc.setNomart(n);
                           lc.setPrix((int)Float.parseFloat(p));
                            System.out.println(p);
                         
                    

                        // Produit p = Produit(obj.get)
                       // lc.setIdpanier(id);
                        lc.setIdpanier(id);
                         //System.out.println(id);
                        
                        lc.setQuantitepanier(quantite);
                        lc.setIduser(u.getId()); 
                       
                      
                        
                        
                        //p.setQuantitearticles((int) Float.parseFloat(obj.get("quantitearticle").toString()));
                     //  p.setIdarticle((int)Float.parseFloat(obj.get("idarticle").toString()));
                      // p.setNomarticle(obj.get("nomarticle").toString());
                        //System.out.println(p);
                        //lc.setIdarticle(p);
                       // lc.setNomart(p.getNomarticle());
                       // lc.setPrix(p.getPrixarticle());
                        listLigneCommande.add(lc);

                    }
                    System.out.println("voirpanier");

                    System.out.println("vu lol ");
                } catch (IOException ex) {

                }

            }
        });
        System.out.println("yu");
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listLigneCommande);
        return listLigneCommande;
    }
     public String payer(String carte ,String mdp) {
        ConnectionRequest con = new ConnectionRequest();
        LigneCommande L =new LigneCommande();
        String Url = "http://localhost/codetest/web/app_dev.php/vente/carte/"+2;
        con.setUrl(Url); 
        con.addArgument("carte", carte);
        con.addArgument("mdp", mdp);
        con.addResponseListener(e -> {
            retour = new String(con.getResponseData());
        });
       NetworkManager.getInstance().addToQueueAndWait(con);
       return retour.substring(1, retour.length() - 1);
    }

    
}


    

