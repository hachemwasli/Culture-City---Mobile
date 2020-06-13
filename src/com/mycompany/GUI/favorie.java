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
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entity.Club;
import com.mycompany.Service.ClubService;
import java.io.IOException;

/**
 *
 * @author yassmine
 */
public class favorie {

    Form f;
    Database db;
    public favorie (Resources theme){
           f = new Form("Clubs favorie", BoxLayout.y());
            f.getToolbar().setTitle("List of favorites");
        Toolbar tb = f.getToolbar();
        Container c = new Container(new FlowLayout(Component.CENTER));
        c.add(new Label("                                 "));
        c.add(new Label("                                 "));

        c.add(new Label("                                 "));

       // EncodedImage palceHolder = EncodedImage.createFromImage(theme.getImage("log.png"), false);

//        URLImage urlImage = URLImage.createToStorage(palceHolder, Login.hama.getImage(), "http://localhost/culture/web/uploads/images/" + Login.hama.getImage());

     //  Image profilePic = urlImage;

        Image mask = theme.getImage("round-mask.png");
        mask = mask.scaledHeight(mask.getHeight() / 4 * 3);
      //  profilePic = profilePic.fill(mask.getWidth(), mask.getHeight());
      //  Label profilePicLabel = new Label(Login.hama.getNom(), profilePic, "SideMenuTitle");
      //  profilePicLabel.setMask(mask.createMask());

     //   Container sidemenuTop = BorderLayout.center(profilePicLabel);

     //   sidemenuTop.setUIID("SidemenuTop");

      //  getToolbar().addComponentToSideMenu(sidemenuTop);
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
        
           
                try {
                   // boolean created = Database.exists("favoritey.db");
                    db = Database.openOrCreate("favoritey.db");

                  
                        db.execute("create table favoritey (idClub INTEGER PRIMARY KEY AUTOINCREMENT, nomClub TEXT,logoClub TEXT, descriptionClub TEXT);");
                    
              
                     //ajouter dans la base de donnée
                  
                    //affichage de la base donnée 
                    Cursor result = db.executeQuery("select * from favoritey;");
                    while (result.next()) {
                     
                        Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
                        Container c2 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        Container c3 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
                        Row r = result.getRow();
                        ImageViewer img = new ImageViewer();
                        EncodedImage palceHolder = EncodedImage.create("/load.png");
                        URLImage urlImage = URLImage.createToStorage(palceHolder,r.getString(2), "http://localhost/Codetest/web/images/" + r.getString(2));
                        img.setImage(urlImage);
                        c1.add(img);
                        Label ch = new Label("Name of club",r.getString(1));
                        ch.setUIID("BlueLabel");
                        c2.add(ch);
                        SpanLabel description = new SpanLabel(r.getString(3));
                        c2.add(description);
                        c1.add(c2);
                        c3.add(c1);
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        f.add(c3);
            
                        f.show();
                    }} catch (IOException ex) {
                }
          
    }
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }   
}
