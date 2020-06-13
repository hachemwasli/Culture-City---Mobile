/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Service;

import com.mycompany.Entity.Emprunt;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS X541UJ
 */
public class ServiceEmprunt {
       public ArrayList<Emprunt> getList2() {
           ArrayList<Emprunt> listEmprunt = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/library/emprunt/find/2");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    //listTasks = getListTask(new String(con.getResponseData()));
                    JSONParser jsonp = new JSONParser();

                    System.out.println("Contenu d panier");
                    //renvoi une map avec clé = root et valeur le reste
                    Map<String, Object> Empruntp = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                    System.out.println("roooooot:" + Empruntp.get("root"));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) Empruntp.get("root");
                    System.out.println("9baal lfor");
                     Map<String, Object> timestamp = (Map<String, Object>) Empruntp.get("dateDebut");
                     Map<String, Object> timestamp2 = (Map<String, Object>) Empruntp.get("dateRetour");
                    double timestpam_date = (double) timestamp.get("timestamp");
                     double timestpam_date2 = (double) timestamp2.get("timestamp");
                Date dt = new Date((long) (timestpam_date * 1000));
                DateFormat df = new SimpleDateFormat("dd-MM-yyyy");

                Date dt1 = new Date((long) (timestpam_date2 * 1000));
               


                       // Map<String, Object> data1 = (Map<String, Object>) (obj.get("idlivre"));
                      
                                         System.out.println("hello");
                       Map<String, Object> den = (Map<String, Object>) Empruntp.get("idLivre");

                        System.out.println("fil for");
                        Emprunt e = new Emprunt();
               
                           
                        e.setId((int) Float.parseFloat(Empruntp.get("id").toString()));
                               e.setId((int) Float.parseFloat(Empruntp.get("id").toString()));
               
               e.setId_livre(den.get("titreLivre").toString());
                     e.setDate_debut(df.format(dt));
                e.setDate_retour(df.format(dt1));

                        listEmprunt.add(e);

                   
                    System.out.println("voirpanier");

                    System.out.println("vu lol ");
                } catch (IOException ex) {

                }

            }
        });
        System.out.println("fgffffffffffffgfg");
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(listEmprunt);
        return listEmprunt;
       }
    


  public void AjouterEmprunt()
    {
       String format = "dd/MM/yy";

java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
java.util.Date date = new java.util.Date();

String sToday = date.toString();
         ConnectionRequest con = new ConnectionRequest();// création d'une nouvelle demande de connexion
        String Url = "http://localhost/projet/web/app_dev.php/library/emprunt/newa?DateDebut=" +"16-07-2020"+ "&DateRetour=16-09-2020" +"&idLivre=1"+"&idUser=1" ;// création de l'URL
        con.setUrl(Url);// Insertion de l'URL de notre demande de connexion

       
        NetworkManager.getInstance().addToQueueAndWait(con);// Ajout de notre demande de connexion à la file d'attente du NetworkManager
        
    }  

    
}
