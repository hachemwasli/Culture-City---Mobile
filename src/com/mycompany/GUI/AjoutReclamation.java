/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

import com.mycompany.Entity.Reclamation;
import com.mycompany.Service.ReclamationService;

/**
 *  
 * @author Zliaa
 */
public class AjoutReclamation  extends Form {
    Reclamation reclamation;
    ReclamationService reclamationService;

    public AjoutReclamation(Resources theme) {
        getToolbar().setTitle("Ajouter une Reclamation");
        getToolbar().addCommandToLeftBar("", theme.getImage("back.png"), e -> new Home(theme).show());

        
        reclamationService = new ReclamationService();
 //       getToolbar().addCommandToLeftBar("", theme.getImage("back.png"), null);
        Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container c2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container c3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));

        EncodedImage palceHolder = EncodedImage.createFromImage(theme.getImage("reclamation.png"), false);
        ImageViewer img = new ImageViewer(palceHolder);
        Label objet = new Label("Objet : ");
        objet.setUIID("LabelBlue");
        Label desc = new Label("description : ");
        desc.setUIID("LabelBlue");
        
        TextField obj = new TextField();
        TextArea descrip = new TextArea(10, 15);

        //reclam.png
        Button btn = new Button("Reclamer");
        btn.setIcon(theme.getImage("reclam.png"));

         Button btnannumer = new Button("Annuler");
          btnannumer.setIcon(theme.getImage("annuler.png"));
         // annuler.png
        c3.add(new Label(" "));
        c3.add(img);
        c1.add(objet);
        c1.add(obj);

        c2.add(desc);
        c2.add(descrip);
        c3.add(new Label(" "));
        c3.add(c1);
        c3.add(c2);
        c3.add(new Label(" "));
        c3.add(btn);
        c3.add(btnannumer);
        add(c3);

        btn.addActionListener((evt) -> {
            reclamation = new Reclamation();
            reclamation.setObjet(obj.getText());
            reclamation.setDescription(descrip.getText());
            System.out.println(reclamation );

            reclamationService.Addreclamation(reclamation);
            Dialog.show("Dialog Title", "Reclamation ajouté avec succès", "OK", null);
                obj.setText("");
                descrip.setText("");
            MesReclamations mr = new MesReclamations(theme);
            mr.show();
            refreshTheme();
        });
        btnannumer.addActionListener((evt) -> {
            MesReclamations mr = new MesReclamations(theme);
            mr.show();
            refreshTheme();
        
        });
        
    }
/*
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    */
}
