/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.mycompany.Entity.Livre;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import static com.codename1.ui.layouts.BoxLayout.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jdk.nashorn.internal.ir.RuntimeNode;

/**
 *
 * @author ASUS X541UJ
 */
public class ServiceLivre {
     public ArrayList<Livre> parseListJsonLivre(String json) {
          ArrayList<Livre> listLivre = new ArrayList<>();

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
            Map<String, Object> tasks = j.parseJSON(new CharArrayReader(json.toCharArray()));
                       
            
            /* Ici on récupère l'objet contenant notre liste dans une liste 
            d'objets json List<MAP<String,Object>> ou chaque Map est une tâche                
            */
            List<Map<String, Object>> list = (List<Map<String, Object>>) tasks.get("root");

            //Parcourir la liste des tâches Json
            for (Map<String, Object> obj : list) {
                //Création des tâches et récupération de leurs données
                Livre e = new Livre();

            Map<String, Object> den = (Map<String, Object>) obj.get("idCategoriel");
             
                
                
                
                
                e.setIdL((int) Float.parseFloat(obj.get("id").toString()));
                e.setTitreL(obj.get("titreLivre").toString());
                e.setDateEdition((obj.get("dateEdition").toString()));
                e.setAuteur((obj.get("auteur").toString()));
                e.setImg((obj.get("cover").toString()));
                //e.setIdCL((int) Float.parseFloat(obj.get("placeTotal").toString()));
                e.setIdCL(den.get("genre").toString());
                

                e.setCopie_dispo(obj.get("copieDispo").toString());

                //e.setDescription(obj.get("description").toString()); 
               // System.out.println(e);
                
                listLivre.add(e);

            }

        } catch (IOException ex) {
        }
        
        /*
            A ce niveau on a pu récupérer une liste des tâches à partir
        de la base de données à travers un service web
        
        */
        System.out.println(listLivre);
        return listLivre;
         
     }
         ArrayList<Livre> listLivre = new ArrayList<>();

       public ArrayList<Livre> getListLivre(){       
    
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/projet/web/app_dev.php/library/livre/all");  
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ServiceLivre ser = new ServiceLivre();
                listLivre = ser.parseListJsonLivre(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listLivre;
    }
    
   
}
