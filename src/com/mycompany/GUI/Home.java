/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;

/**
 *
 * @author Zliaa
 */
public class Home extends Form {

    public Home(Resources theme) {
        getToolbar().setTitle("Home");
        Toolbar tb = getToolbar();
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
            ListeEvennements ev = new  ListeEvennements(theme);
            ev.show();
      //      try {
      //          new listCommande(theme).show();
      //      } catch (IOException ex) {
      //          System.out.println("erreur");
      //      }
        });
        tb.addMaterialCommandToSideMenu("Reclamations", FontImage.MATERIAL_SETTINGS, e -> {
            MesReclamations rec = new  MesReclamations(theme);
            rec.show();
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

   //EncodedImage palceHolder2 = EncodedImage.createFromImage(theme.getImage("Cit-de-la-culture3.png"), false);

        //   ImageViewer img = new ImageViewer(palceHolder2);
       // c.add(palceHolder2);
           c.add(new Label("                                              "));
      //  Label l = new Label("");
      //  l.setUIID("Junior Developers");
      //  c.add(l);
        c.add(new Label(""));
        EncodedImage palceHolder3 = EncodedImage.createFromImage(theme.getImage("culureccn.jpg"), false);
        c.add(palceHolder3);
        add(c);
    }

}
