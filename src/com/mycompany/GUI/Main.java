/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import static com.codename1.push.PushContent.setTitle;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author ASUS X541UJ
 */
public class Main extends Form {
    

   
    public Main(Resources theme){
         getToolbar().setTitle("Home");
        Toolbar tb = getToolbar();
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
        
        getToolbar().addCommandToOverflowMenu("My loans", null, new ActionListener() {
     

            @Override
            public void actionPerformed(ActionEvent evt) {
               Emprunts e =new Emprunts(theme);
                e.show(); 
            }
        });

        getToolbar().addCommandToOverflowMenu("Logout", null, new ActionListener() {
     

            @Override
            public void actionPerformed(ActionEvent evt) {
                Main m =new Main(theme);
                m.show(); 
            }
        });
       Form F = new Form("",BoxLayout.y());
   
        setTitle("Welcome to library");
        Label t = new Label(" Welcome to library departement ");
        ImageViewer img = new ImageViewer(theme.getImage("bib.jpg"));

             Button btn_Bib = new Button("Access to the library");
    btn_Bib.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               Livres l = new Livres(theme);
               l.show();
            }
});
        
        
        add(t);
        add(img);
        add(btn_Bib);
      
    }

    

 
    
}
