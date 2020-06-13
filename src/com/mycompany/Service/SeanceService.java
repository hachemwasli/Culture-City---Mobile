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
import com.mycompany.Entite.Film;
import com.mycompany.Entite.Seance;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mnif
 */
public class SeanceService {
    
    
    ArrayList<Seance> listSeances = new ArrayList<>();
    
    
     public ArrayList<Seance> getList() {
        ArrayList<Seance> listSeances = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/cinema/allSeance");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> seances = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                   // System.out.println(seances);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) seances.get("root");
                    for (Map<String, Object> obj : list) {
                        Seance s = new Seance();
                        Film f = new Film();
                         s.setDate_seance(new Date((((Double) ((Map<String, Object>) obj.get("date")).get("timestamp")).longValue() * 1000)));
                         s.setFilm(obj.get("nom").toString());
                         s.setSalle(obj.get("nomSalle").toString());
                         f.setImage_film(obj.get("image").toString());
                         System.out.println(f); 
                        listSeances.add(s);
                        System.out.println(s);
                     //   float id = Float.parseFloat(obj.get("id_seance").toString());
              
                      // s.setId_seance(((Double) obj.get("id_seance")).intValue());
                       
                      //  s.setDate_seance(new Date((((Double) ((Map<String, Object>) obj.get("date")).get("timestamp")).longValue() * 1000)));
                       // s.setFilm(((Map<String, Object>) obj.get("id_film")).get("nom_film").toString());
                        //s.setFilm(((Map<String, Object>) obj.get("film")).get("imageFilm").toString());
                        //s.setSalle(((Map<String, Object>) obj.get("numero_salle")).get("nom_salle").toString());
                        //listSeances.add(s);
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listSeances;
    }
     
      
     public ArrayList<Film> getList1(String name) {
        ArrayList<Film> listFilm = new ArrayList<>();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/cinema/getDetails/"+name);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                
                JSONParser jsonp = new JSONParser();
                
                try {
                    Map<String, Object> seances = jsonp.parseJSON(new CharArrayReader(new String(con.getResponseData()).toCharArray()));
                   // System.out.println(seances);
                    List<Map<String, Object>> list = (List<Map<String, Object>>) seances.get("root");
                    for (Map<String, Object> obj : list) {
                        Film f = new Film();
                        f.setImage_film(obj.get("imageFilm").toString());
                        f.setNom_film(obj.get("nomFilm").toString());
                        f.setCategorie_film(obj.get("categorieFilm").toString());
                        f.setDescription_film(obj.get("descriptionFilm").toString());
                        
                       
                        
                        
                        
                         System.out.println(f); 
                        listFilm.add(f);
                    
                    }
                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listFilm;
    }
     /*
     public Seance rechercheSeance(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/cinema/recherche/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                SeanceService ser = new SeanceService();
                listSeances = ser.getList();
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listSeances.get(0);
    }
     */
     
     
     
     
    
}
