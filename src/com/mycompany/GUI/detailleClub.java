/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author yassmine
 */
public class detailleClub { 

Database db;
Form f ;

    
    public detailleClub  (Resources theme) throws IOException{
        f = new Form (ListeClub.club.getNomClub());

        Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
          
          f.getToolbar().setTitle(ListeClub.club.getNomClub());
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
         
        });
        tb.addMaterialCommandToSideMenu("Cinema", FontImage.MATERIAL_SETTINGS, e -> {
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
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
         ImageViewer img = new ImageViewer();
            EncodedImage palceHolder = EncodedImage.create("/load.png");
              URLImage urlImage = URLImage.createToStorage(palceHolder, ListeClub.club.getLogoClub(), "http://localhost/Codetest/web/images/" + ListeClub.club.getLogoClub());
         

            img.setImage(urlImage);
            c2.add(img);
            Label ch = new Label("Title"+ListeClub.club.getNomClub());
           
            ch.getAllStyles().setPaddingTop(0);
               c2.add(ch);
            SpanLabel ch1 = new SpanLabel("Description : "+ListeClub.club.getDescriptionClub());
           
            ch.getAllStyles().setPaddingTop(0);
               c2.add(ch1);

                  Button xx = new Button ("favorite");
            c2.add(xx);
           
            xx.addActionListener((ActionEvent evt) -> {
                try {
                    boolean created = Database.exists("favoritey.db");
                    db = Database.openOrCreate("favoritey.db");

                    if (created == false) {
                        db.execute("create table favoritey (idClub INTEGER PRIMARY KEY AUTOINCREMENT, nomClub TEXT,logoClub TEXT, descriptionClub TEXT);");
                    }
                     //ajouter dans la base de donnée
                    
                           Cursor result1 = db.executeQuery("select nomClub from favoritey;");
                           boolean existe = false;
                     while (result1.next()) {
                        Row r2 = result1.getRow();
                        if (r2.getString(0).equals(ListeClub.club.getNomClub())){
                            existe= true;
                           
                     }}
                     if (existe==true){ Dialog.show("Alert", "club exist", "ok", null);
                         ListeClub  l = new ListeClub(theme);
                l.getF().show();
                     }
                     if (existe==false){
                     
                    db.execute("insert into favoritey (nomClub,logoClub,descriptionClub) values ('" +ListeClub.club.getNomClub() + "','" + ListeClub.club.getLogoClub() + "','" + ListeClub.club.getDescriptionClub()+ "');");
                    //affichage de la base donnée 
                    Cursor result = db.executeQuery("select * from favoritey;");
                    while (result.next()) {
                        Row r = result.getRow();
                        String info = r.getString(0) + " " + r.getString(1)+ " " + r.getString(2)+ " " + r.getString(3);
                        System.out.println(info);
                        
                            favorie  lo = new favorie(theme);
                lo.getF().show();
                        //supprimer de la base de donnée
                       // db.execute("delete from subs  where code =1");
                        //modifier de la base de donnée
                        // db.execute("update tache set etat=' Done' where titre='"+titre+"';");
                        
                        

                    }
                }} catch (IOException ex) {
                }
            
});
                            Button xy = new Button ("delete");
            c2.add(xy);
           
            xy.addActionListener((ActionEvent ev) -> {
                try {
                    boolean created = Database.exists("favoritey.db");
                    db = Database.openOrCreate("favoritey.db");

                    if (created == false) {
                        db.execute("create table favoritey (idClub INTEGER PRIMARY KEY AUTOINCREMENT, nomClub TEXT,logoClub TEXT, descriptionClub TEXT);");
                    }
                     //ajouter dans la base de donnée
                    
                           Cursor result1 = db.executeQuery("select nomClub from favoritey;");
                           boolean existe1 = false;
                     while (result1.next()) {
                        Row r2 = result1.getRow();
                        if (r2.getString(0).equals(ListeClub.club.getNomClub())){
                            existe1= true;
                           
                     }}
                     if (existe1==false){ Dialog.show("Alert", "nothing to delete", "ok",null);
                         ListeClub  l = new ListeClub(theme);
                          l.getF().show();
                     }
                     if (existe1==true){
                         Dialog.show("Alert", "are you sure?", "ok",null);
                     db.execute("delete from 'favoritey' where nomClub='"+ListeClub.club.getNomClub()+"';");
                   
                    //affichage de la base donnée 
                    Cursor result = db.executeQuery("select * from favoritey;");
                    while (result.next()) {
                        Row r = result.getRow();
                        String info = r.getString(0) + " " + r.getString(1)+ " " + r.getString(2)+ " " + r.getString(3);
                        System.out.println(info);
                        
       
                        //supprimer de la base de donnée
                       // db.execute("delete from subs  where code =1");
                        //modifier de la base de donnée
                        // db.execute("update tache set etat=' Done' where titre='"+titre+"';");
                        
                        

                    }
                }} catch (IOException ex) {
                }
            
                });

            f.add(c2);
            
            f.show();
            


    }
      public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }}

