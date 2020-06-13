/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entity.Evennement;
import com.mycompany.Entity.Image;
import com.mycompany.Service.EvennementService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zliaa
 */
public class DetailEvennement extends Form {

    URLImage urlImage2;
    EvennementService evennementService;
    Evennement evennement;
    java.util.Date dt = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    List<Image> galrielst;
    int j, i = 0;

    public DetailEvennement(Resources theme) {

        Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container c3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Container pag = new Container(new BoxLayout(BoxLayout.X_AXIS));
        Container c11 = new Container(new FlowLayout(Component.CENTER));
        Container cc = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        evennement = ListeEvennements.evennement;

        evennementService = new EvennementService();
        galrielst = evennementService.getGalerie(evennement.getId());

        ListeEvennements le = new ListeEvennements(theme);
        getToolbar().setTitle("Détail Evenement");
        getToolbar().addCommandToLeftBar("", theme.getImage("back.png"), e -> le.show());
        getToolbar().addCommandToOverflowMenu("ajout une reclamation", theme.getImage("add.png"), e -> new AjoutReclamation(theme).show());
        Container c1 = new Container(new FlowLayout(Component.CENTER));

        EncodedImage btnsuiv = EncodedImage.createFromImage(theme.getImage("suiv.png"), false);
        ImageViewer imgsuiv = new ImageViewer(btnsuiv);
        EncodedImage btnprec = EncodedImage.createFromImage(theme.getImage("prec.png"), false);
        ImageViewer imgprec = new ImageViewer(btnprec);

        Button suiv = new Button(btnsuiv);
        Button prec = new Button(btnprec);

        ImageViewer img = new ImageViewer();

        Button btnPart = new Button("Partage");
        btnPart.setIcon(theme.getImage("face.png"));
        EncodedImage palceHolder = EncodedImage.createFromImage(theme.getImage("log.png"), false);
        URLImage urlImage = URLImage.createToStorage(palceHolder, evennement.getImage(), "http://localhost/culture/web/uploads/images/" + evennement.getImage());

        Label l = new Label(" ");
        l.setUIID("Separator");

        Label desc = new Label("Description : " + evennement.getDescription());
        desc.setUIID("BlueLabel");

        img.setImage(urlImage);

        c2.add(new Label(" "));
        c2.add(desc);
        c2.add(new Label(" "));
        c1.add(c2);

        i = galrielst.size();
        Label titre;
        if (i > 0) {
            titre = new Label("Affiche                        Galerie");
        } else {
            titre = new Label("     Affiche    ");
        }

        titre.setUIID("BlueLabel");
        c1.add(titre);

        cc.add(img);
        cc.add(btnPart);
        c1.add(cc);

        c1.add(l);
        ImageViewer galerie = new ImageViewer();

        prec.setVisible(false);
        prec.setHidden(true);
        if (i > 0) {
            urlImage2 = URLImage.createToStorage(palceHolder, galrielst.get(j).getPath(), "http://localhost/culture/web/uploads/images/" + galrielst.get(j).getPath());
            galerie.setImage(urlImage2);
            c3.add(galerie);
            pag.add(prec);
            pag.add(suiv);
            c11.add(pag);

            suiv.addActionListener((evt) -> {
                j++;
                urlImage2 = URLImage.createToStorage(palceHolder, galrielst.get(j).getPath(), "http://localhost/culture/web/uploads/images/" + galrielst.get(j).getPath());
                galerie.setImage(urlImage2);
                if (j > 0) {
                    prec.setVisible(true);
                    prec.setHidden(false);
                }
                if (j == i - 1) {
                    suiv.setVisible(false);
                    suiv.setHidden(true);
                }
                refreshTheme();
            });

            prec.addActionListener((evt) -> {
                j--;
                urlImage2 = URLImage.createToStorage(palceHolder, galrielst.get(j).getPath(), "http://localhost/culture/web/uploads/images/" + galrielst.get(j).getPath());
                galerie.setImage(urlImage2);
                if (j < 1) {
                    prec.setVisible(false);
                    prec.setHidden(true);
                };
                if (j < i - 1) {
                    suiv.setVisible(true);
                    suiv.setHidden(false);
                };
                refreshTheme();
            });

        }

        btnPart.addActionListener((evt) -> {
            Display.getInstance().execute("https://www.facebook.com/sharer/sharer.php?u="
                    + "http://127.0.0.1/codetest/web/app_dev.php/evenement/detail" + evennement.getId());

        });

        c3.add(c11);
        c1.add(c3);
        add(c1);

        Container c8 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        c8.add(new Label("                                    "));

        Label l1 = new Label("Date Debut : " + sdf.format(evennement.getDtDebut()));
        l1.setUIID("black");
        c8.add(l1);
        Label l2 = new Label("Date Fin : " + sdf.format(evennement.getDtFin()));
        l2.setUIID("black");

        c8.add(l2);

        Label l3 = new Label("Nombre de Place : " + evennement.getNbPlace());
        l3.setUIID("black");

        c8.add(l3);

        Label l4 = new Label("prix : " + evennement.getPrix());
        l4.setUIID("black");

        c8.add(l4);
        c1.add(c8);
       
     
    }

}
