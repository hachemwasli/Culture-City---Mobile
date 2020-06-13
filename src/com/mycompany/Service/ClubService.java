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
import com.mycompany.Entity.Club;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author yassmine
 */
public class ClubService {
      ArrayList<Club> listClub = new ArrayList<>();

    public ArrayList<Club> parseListTaskJson(String json) {
        ConnectionRequest con = new ConnectionRequest();
        ArrayList<Club> listClubs = new ArrayList<>();
        try {
            JSONParser j = new JSONParser();
            Map<String, Object> Clubs = j.parseJSON(new CharArrayReader(json.toCharArray()));
            List<Map<String, Object>> list = (List<Map<String, Object>>) Clubs.get("root");
            for (Map<String, Object> obj : list) {
                Club e = new Club();
                float idClub = Float.parseFloat(obj.get("idClub").toString());
                e.setIdClub(((Double) obj.get("idClub")).intValue());
                e.setNomClub(obj.get("nomClub").toString());
                e.setLogoClub(obj.get("logoClub").toString());
                e.setDescriptionClub(obj.get("descriptionClub").toString());
                listClubs.add(e);
                System.out.println(e);
                
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return listClubs;
    }

    public ArrayList<Club> consulterServices() {
        ConnectionRequest con = new ConnectionRequest();

        con.setUrl("http://localhost/codetest/web/app_dev.php/club1/allclub");
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                ClubService ser = new ClubService();
                listClub = ser.parseListTaskJson(new String(con.getResponseData()));
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return listClub;
    }
    
}
