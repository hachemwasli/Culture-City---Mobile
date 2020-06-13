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
import com.mycompany.Entity.Reclamation;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Zliaa
 */
public class ReclamationService {

    ArrayList<Reclamation> lstReclmat = new ArrayList<>();

    public ArrayList<Reclamation> parseListReclamationJson(String json) {
        ConnectionRequest con = new ConnectionRequest();
        ArrayList<Reclamation> listReclmat = new ArrayList<>();

        try {
            JSONParser j = new JSONParser();
            Map<String, Object> Evennements = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) Evennements.get("root");
            for (Map<String, Object> obj : list) {
                Reclamation e = new Reclamation();

                e.setId(((Double) obj.get("id")).intValue());
                e.setDescription(obj.get("description").toString());
                e.setObjet(obj.get("objet").toString());
                e.setDatecreation(new Date((((Double) ((Map<String, Object>) obj.get("datecreation")).get("timestamp")).longValue() * 1000)));
                listReclmat.add(e);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return listReclmat;
    }

    public ArrayList<Reclamation> consulterReclamations(int id) {
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/reclamation/mobile/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ReclamationService ser = new ReclamationService();
                lstReclmat = ser.parseListReclamationJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return lstReclmat;
    }

    public void Supprimer(int id){
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/reclamation/delete/mobile/" + id);
        NetworkManager.getInstance().addToQueueAndWait(con);
    }


public void Addreclamation(Reclamation rec)
    {

        System.out.println(rec);
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/codetest/web/app_dev.php/reclamation/add/mobile/"+1);
        con.addArgument("objet", rec.getObjet());
        con.addArgument("description", rec.getDescription());       
        con.addArgument("user", Integer.toString(1));
       
      ///
    /*
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                //System.out.println("json :" + json);
                JSONParser j = new JSONParser();

            }
        });*/
        
        NetworkManager.getInstance().addToQueueAndWait(con);
        
    }
}
