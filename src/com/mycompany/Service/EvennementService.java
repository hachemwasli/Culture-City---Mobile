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
import com.mycompany.Entity.Evennement;
import com.mycompany.Entity.Image;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Zliaa
 */
public class EvennementService {

    ArrayList<Evennement> listEvenement = new ArrayList<>();
    ArrayList<Image> lstgal = new ArrayList<>();

    public ArrayList<Evennement> parseListTaskJson(String json) {
        ConnectionRequest con = new ConnectionRequest();
        ArrayList<Evennement> listEvnets = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> Evennements = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) Evennements.get("root");
            for (Map<String, Object> obj : list) {
                Evennement e = new Evennement();
                float id = Float.parseFloat(obj.get("id").toString());
                e.setId(((Double) obj.get("id")).intValue());
                e.setDescription(obj.get("description").toString());
                e.setDtDebut(new Date((((Double) ((Map<String, Object>) obj.get("dtDebut")).get("timestamp")).longValue() * 1000)));
                e.setDtFin(new Date((((Double) ((Map<String, Object>) obj.get("dtFin")).get("timestamp")).longValue() * 1000)));
                e.setEntree(obj.get("entree").toString());
                e.setImage(obj.get("image").toString());
                e.setPrix(((Double) obj.get("prix")).floatValue());
                e.setNbPlace(((Double) obj.get("nbPlace")).intValue());
                listEvnets.add(e);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return listEvnets;
    }

    public ArrayList<Evennement> consulterEvennements() {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/evenement/liste/mobile");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EvennementService ser = new EvennementService();
                listEvenement = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvenement;
    }

    String response;

    public int nbLike(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/evenement/" + id + "/mobile");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                response = new String(con.getResponseData());

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);

        return Integer.parseInt(response);
    }

    public boolean isliked(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                response = new String(con.getResponseData());

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return Boolean.parseBoolean(response);
    }

    public int likeDislike(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                response = new String(con.getResponseData());
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(response);
        return Integer.parseInt(response);
    }

    public Evennement rechercheEvennements(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/evenement/recherche/mobile/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EvennementService ser = new EvennementService();
                listEvenement = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listEvenement.get(0);
    }

    public ArrayList<Image> parseListImageJson(String json) {
        ConnectionRequest con = new ConnectionRequest();
        ArrayList<Image> galerie = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> galeries = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) galeries.get("root");
            for (Map<String, Object> obj : list) {
                Image e = new Image();
                float id = Float.parseFloat(obj.get("id").toString());
                e.setId(((Double) obj.get("id")).intValue());
                e.setPath(obj.get("image").toString());

                galerie.add(e);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return galerie;
    }

    public List<Image> getGalerie(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/evenement/galerie/mobile/"+id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                EvennementService ser = new EvennementService();
                lstgal = ser.parseListImageJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        System.out.println(lstgal);
        return lstgal;
    }
}
