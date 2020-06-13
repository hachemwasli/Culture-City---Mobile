/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.mycompany.Entity.Emprunt;

import com.mycompany.Service.ServiceEmprunt;

import com.codename1.components.MultiButton;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.util.ArrayList;

/**
 *
 * @author ASUS X541UJ
 */
public class Emprunts extends Form {
    
    
    public Emprunts (Resources Theme) {
      
        ServiceEmprunt ls = new ServiceEmprunt();
       
           //   Emprunt.setId_utilisateur(1);
 getToolbar().addCommandToOverflowMenu("My loans", null, new ActionListener() {
     

            @Override
            public void actionPerformed(ActionEvent evt) {
               Emprunts e =new Emprunts(Theme);
                e.show(); 
            }
        });

        getToolbar().addCommandToOverflowMenu("Logout", null, new ActionListener() {
     

            @Override
            public void actionPerformed(ActionEvent evt) {
                Main m =new Main(Theme);
                m.show(); 
            }
        });
         getToolbar().addCommandToLeftBar("back", null, new ActionListener() {
     

            @Override
            public void actionPerformed(ActionEvent evt) {
              Main m =new Main(Theme);
                m.show();  
            }
        });
        ArrayList<Emprunt> sl = ls.getList2();
        Container Emprunts = new Container(BoxLayout.y());
        Emprunts.setUIID("List");
        Emprunts.setScrollableY(true);
        setTitle("My loans");
        if (ls != null) {
            for (Emprunt l : sl) {

               
                MultiButton mb = new MultiButton(l.getId_livre());
                mb.setUIID("ListItem");
                mb.setTextLine3(l.getId_livre());
                mb.setTextLine3(l.getDate_debut());
                mb.setTextLine2(l.getDate_retour());
              
            
                //Slider note = createStarRankSlider();
              
               Emprunts.add(FlowLayout.encloseCenter(mb));
            }
            add(Emprunts);
        } else {
            //TO DO
        
    }
    
    }
    
    
}
