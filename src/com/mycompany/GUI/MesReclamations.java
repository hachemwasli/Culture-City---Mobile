/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entity.Reclamation;
import com.mycompany.Service.ReclamationService;
import java.util.ArrayList;

/**
 *
 * @author Zliaa
 */
public class MesReclamations extends Form {

    ReclamationService reclamationService;

    ArrayList<Reclamation> lstrec;
    java.util.Date dt = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

    public MesReclamations(Resources theme) {
        reclamationService = new ReclamationService();

  
        getToolbar().setTitle("Mes Reclamations");
        getToolbar().addCommandToLeftBar("", theme.getImage("back.png"), e -> new Home(theme).show());

        lstrec = reclamationService.consulterReclamations(Login.hama.getId());

        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
 
        Button supp;
        for (Reclamation rec : lstrec) {

            Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            
            Container c3 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label l = new Label("Objet : ");
            l.setUIID("LabelBlue");
            Label ch1 = new Label(rec.getObjet());
            ch1.setUIID("labelblack");

            c3.add(l);
            c3.add(ch1);

            c2.add(c3);
            Label ch2 = new Label(rec.getDescription());
            ch2.setUIID("black");
            c2.add(ch2);
             Container c4 = new Container(new BoxLayout(BoxLayout.X_AXIS));
             Label ch5 = new Label("Date Reclamation : ");
             ch5.setUIID("LabelBlue");
            Label ch3 = new Label(sdf.format(rec.getDatecreation()));
            c4.add(ch5);
             ch3.setUIID("rouge");
            c4.add(ch3);
            
            c2.add(c4); 
            
            supp = new Button("Supprimer");
            supp.setIcon(theme.getImage("delete.png"));
            c2.add(supp);

            c2.add(new Label("   "));

            c.add(c2);

            supp.addActionListener((evt) -> {
                reclamationService.Supprimer(rec.getId());
                Dialog.show("Dialog Title", "Reclamation supprimé avec succès", "OK", null);
                MesReclamations mesReclamations = new MesReclamations(theme);
                mesReclamations.show();
                refreshTheme();

            });
        }
        add(c);
    }

}
