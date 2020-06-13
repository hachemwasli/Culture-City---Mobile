/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.html.HTMLElement;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListCellRenderer;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.Entity.Evennement;
import com.mycompany.Service.EvennementService;
import java.util.ArrayList;
 
 

/**
 *
 * @author Zliaa
 */
public class ListeEvennements extends Form {

    EvennementService evennementService;
    ArrayList<Evennement> lstEvent;
    java.util.Date dt = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
    static Evennement evennement;

    public ListeEvennements(Resources theme) {
       
       
        Toolbar.setGlobalToolbar(true);
        getToolbar().addCommandToLeftBar("",theme.getImage("back.png"), e->new Home(theme).show());
        Style s = UIManager.getInstance().getComponentStyle("Title");
        TextField searchField = new TextField("", "Recherche evenement"); // <1>
        searchField.getHintLabel().setUIID("Title");
        searchField.setUIID("Title");
        searchField.getAllStyles().setAlignment(Component.LEFT);
        getToolbar().setTitleComponent(searchField);
        FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
        searchField.addDataChangeListener((i1, i2) -> { // <2>
            String t = searchField.getText();
            if (t.length() < 1) {
                for (Component cmp : getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
            } else {
                t = t.toLowerCase();
                for (Component cmp : getContentPane()) {
                    String val = null;
                    if (cmp instanceof Container) {
                        for (Component cmpp : ((Container) cmp).getChildrenAsList(focusScrolling)) {
                            if (cmpp instanceof Container) {
                                for (Component cmppp : ((Container) cmpp).getChildrenAsList(focusScrolling)) {
                                    boolean show = false;
                                    if (cmppp instanceof SpanLabel) {
                                     //   val = ((Label) cmppp).getText();
                                        for (Component cmpp2 : ((Container) cmppp).getChildrenAsList(focusScrolling)) {
                                            if (cmpp2 instanceof TextArea) {
                                                val = ((TextArea) cmpp2).getText();
                                            }
                                        }
                                        show = val != null && val.toLowerCase().indexOf(t) > -1;
                                        cmp.setHidden(!show); // <3>
                                        cmp.setVisible(show);
                                    }
                                    if (show) {
                                        break;
                                    }
                                }
                            }

                        }
                    }
                }
            }
            getContentPane().animateLayout(250);
             Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        evennementService = new EvennementService();

        lstEvent = evennementService.consulterEvennements();
        });
        getToolbar().addCommandToRightBar("", searchIcon, (e) -> {
            searchField.startEditingAsync(); // <4>
        });
        Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        evennementService = new EvennementService();

        lstEvent = evennementService.consulterEvennements();

        for (Evennement event : lstEvent) {

            Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS), "Container*");
            Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS), "c3");
            Container c3 = new Container(new BoxLayout(BoxLayout.Y_AXIS), "c4");
            ImageViewer img = new ImageViewer();
            EncodedImage palceHolder = EncodedImage.createFromImage(theme.getImage("log.png"), false);
            URLImage urlImage = URLImage.createToStorage(palceHolder, event.getImage(), "http://localhost/culture/web/uploads/images/" + event.getImage());

            img.setImage(urlImage);

            Button like = new Button(evennementService.nbLike(event.getId()) + "J'aime");
           

            c2.add(img);
            c1.add(c2);

            Button myBtn = new Button();

            myBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    evennement = event;
                    DetailEvennement de = new DetailEvennement(theme);
                    de.show();
                }
            }
            );

            c2.setLeadComponent(myBtn);

            Label ch = new Label("Description : ");
            ch.setUIID("black");

            c3.add(ch);

            SpanLabel ch2 = new SpanLabel(event.getDescription());
            ch2.setUIID("LabelBlue");

            c3.add(ch2);

            Label ch4 = new Label("Fin:" + sdf.format(event.getDtFin()));

            ch4.setUIID("rouge");
            c3.add(ch4);
            c3.add(like);
            c1.add(c3);
            add(c1);

         

        }

    }

}
