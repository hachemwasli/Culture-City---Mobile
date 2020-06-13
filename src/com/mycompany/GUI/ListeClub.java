/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entity.Club;

import com.mycompany.Service.ClubService;
import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author yassmine
 */
public class ListeClub {
      Form f;
      
    public static Club club;
    ArrayList<Club> listClub;


    public ListeClub(Resources theme) {
        
         f = new Form(BoxLayout.y());
  Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        ClubService cs = new ClubService();
        listClub = cs.consulterServices();
        
        f.getToolbar().setTitle("List of clubs");
        Toolbar tb = f.getToolbar();
        Container chome = new Container(new FlowLayout(Component.CENTER));
        chome.add(new Label("                                 "));
        chome.add(new Label("                                 "));

        chome.add(new Label("                                 "));
  Image mask = theme.getImage("round-mask.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
         tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> {
            new Home(theme).show();
        });
        tb.addMaterialCommandToSideMenu("User session", FontImage.MATERIAL_HOME, e -> {
            new ProfileUser(theme).k.show();
        });
        tb.addMaterialCommandToSideMenu("Events", FontImage.MATERIAL_SETTINGS, e -> {
      //      try {
      //          new listCommande(theme).show();
      //      } catch (IOException ex) {
      //          System.out.println("erreur");
      //      }
        });
        tb.addMaterialCommandToSideMenu("Clubs", FontImage.MATERIAL_WEB, e -> {
     ListeClub liste = new ListeClub(theme);
       liste.getF().show();
        });
        tb.addMaterialCommandToSideMenu("Shop", FontImage.MATERIAL_SETTINGS, e -> {
             HomeForm sale=new HomeForm(theme);
            sale.show();
         
        });
        tb.addMaterialCommandToSideMenu("Cinema", FontImage.MATERIAL_SETTINGS, e -> {
            list liste = new list(theme);
        
             liste.show();
      //      new HomeChayma(theme).Accueil.show();
        });
        tb.addMaterialCommandToSideMenu("Library", FontImage.MATERIAL_INFO, e -> {
          
            
          Main m = new Main(theme);
          m.show();
        });
       
        tb.addMaterialCommandToSideMenu("Account Settings", FontImage.MATERIAL_INFO, e -> {
  //          new QuestionAffichage(theme).show();
        });
        tb.addMaterialCommandToSideMenu("Logout", FontImage.MATERIAL_INFO, e -> {

            Login.hama = null;
            Login.lool = "";
            new Login(theme).show();

        });  
        
        
        
            for (Club clubb : listClub) {

            Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container c5 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container c6 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container c3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            
            ImageViewer img = new ImageViewer();
         
            EncodedImage palceHolder;
            try {
                palceHolder = EncodedImage.create("/load.png");
                URLImage urlImage = URLImage.createToStorage(palceHolder, clubb.getLogoClub(), "http://localhost/Codetest/web/images/" + clubb.getLogoClub());

            img.setImage(urlImage);
            } catch (IOException ex) {
                
            }
            
            c1.add(img);
            Label ch = new Label("Name of club :");
            ch.setUIID("BlueLabel");
            
            SpanLabel nom = new SpanLabel(clubb.getNomClub());
            nom.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
            nom.getAllStyles().setMarginTop(0);
            nom.getAllStyles().setPaddingTop(0);
            c5.add(ch);
            c5.add(nom);
                    
            c3.add(c5);

            c3.add(c6);
           Button xx = new Button ("Read More");
            c3.add(xx);
            
            xx.addActionListener((evt) -> {
                  club = clubb;
                
                
                try {
                  detailleClub  lo = new detailleClub(theme);
                    lo.getF().show();
                } catch (IOException ex) {
                  
                }
                
        });
                       Button stat = new Button ("Statistics");
            c3.add(stat);
            
            stat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                 Container C = new Container(new BoxLayout(BoxLayout.X_AXIS));
                ApiStat a=new ApiStat();
              a.createPieChartForm(theme).show();
              
                f.add(C);
            }
                
        });
    c1.add(c3);
            f.add(c1);
        
        }
      
    }
         public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}

    

