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
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entity.User;
import com.mycompany.Service.UserService;

/**
 *
 * @author user
 */
public class ProfileUser {
    Button modifier;
   
    Form k;
    UserService us = new UserService();
    User u = new User();
    public ProfileUser(Resources theme) {
       

      

    Container c = new Container(new BoxLayout(BoxLayout.Y_AXIS));
    Container c1 = new Container(new BoxLayout(BoxLayout.X_AXIS));
    Container c2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
    Container c3= new Container(new BoxLayout(BoxLayout.X_AXIS));
    Container c4= new Container(new BoxLayout(BoxLayout.X_AXIS));
    Container c5= new Container(new BoxLayout(BoxLayout.X_AXIS));
    k = new Form("Votre profile", BoxLayout.y());
    k.setUIID("formLogin");
//        ListeProgramme ax = new ListeProgramme(theme);
//        f.getToolbar().addCommandToLeftBar("back", theme.getImage("back-command.png"), e -> ax.show());

    u = Login.hama;
    //TextField username = new TextField(u.getUserName());
    
    Button deco = new Button("Déconnecter");

    k.getToolbar().addCommandToLeftBar("", theme.getImage("back.png"), e -> new Home(theme).show());
    
    SpanLabel ch = new SpanLabel("Pseudonyme :    ");
    ch.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
    ch.getAllStyles().setMarginTop(0);
    ch.getAllStyles().setPaddingTop(0);
     SpanLabel chx = new SpanLabel(u.getUserName());
    ch.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
    ch.getAllStyles().setMarginTop(0);
    ch.getAllStyles().setPaddingTop(0);
    SpanLabel ch1 = new SpanLabel("Email :               ");
    ch1.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
    ch1.getAllStyles().setMarginTop(0);
    ch1.getAllStyles().setPaddingTop(0);
    SpanLabel chx1 = new SpanLabel(u.getEmail());
    ch.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
    ch.getAllStyles().setMarginTop(0);
    ch.getAllStyles().setPaddingTop(0);
    SpanLabel ch2 = new SpanLabel("Mot de passe :   ");
    ch2.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
    ch2.getAllStyles().setMarginTop(0);
    ch2.getAllStyles().setPaddingTop(0);
    SpanLabel ch3 = new SpanLabel("Nom :                ");
    ch3.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
    ch3.getAllStyles().setMarginTop(0);
    ch3.getAllStyles().setPaddingTop(0);
    SpanLabel ch4 = new SpanLabel("Prenom :           ");
    ch4.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
    ch4.getAllStyles().setMarginTop(0);
    ch4.getAllStyles().setPaddingTop(0);
    deco.addActionListener(e->{
        Login.hama=null;
        Login.lool="";
        Login a = new Login(theme);
        a.show();
    });
    //username.setEditable(false);
    //TextField email = new TextField(u.getEmail());
    //username.setPreferredSizeStr("36.719578mm 5.4074073mm");
    //email.setEditable(false);
    //TextField password = new TextField("*******");
    //email.setPreferredSizeStr("36.719578mm 5.4074073mm");
    //password.setEditable(false);
    //password.setPreferredSizeStr("36.719578mm 5.4074073mm");
   // TextField nom = new TextField(u.getNom());
   // nom.setEditable(false);
   // nom.setPreferredSizeStr("36.719578mm 5.4074073mm");
   SpanLabel chx3 = new SpanLabel(u.getNom());
    ch3.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
    ch3.getAllStyles().setMarginTop(0);
    ch3.getAllStyles().setPaddingTop(0);
    SpanLabel chx5 = new SpanLabel("******");
    ch3.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
    ch3.getAllStyles().setMarginTop(0);
    ch3.getAllStyles().setPaddingTop(0);
    
    Button xix = new Button ("Montrer");
    xix.addActionListener((evt) -> {
        chx5.setText(Login.lool);
    });
      SpanLabel chx4 = new SpanLabel(u.getPrenom());
    ch3.getTextAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL));
    ch3.getAllStyles().setMarginTop(0);
    ch3.getAllStyles().setPaddingTop(0);
    //TextField prenom = new TextField(u.getPrenom());
    //prenom.setEditable(false);
    //prenom.setPreferredSizeStr("36.719578mm 5.4074073mm");
   // ImageViewer img = new ImageViewer();
  //  EncodedImage palceHolder = EncodedImage.createFromImage(theme.getImage("maxresdefault.png"), false);
   // URLImage urlImage = URLImage.createToStorage(palceHolder, u.getImage(), "http://localhost/culture/web/uploads/images/" + u.getImage());
   // img.setImage(urlImage);
    c1.add(ch);
    c1.add(chx);
    c2.add(ch1);
    c2.add(chx1);
   
    c3.add(ch2);
    c3.add(chx5);
    Button edit = new Button ("Editer");
   c3.add(xix);
   c3.add(edit);
   edit.addActionListener((evt) -> {
      ChangerMdp xxoo = new ChangerMdp (theme);
      xxoo.getF().show();
   });
    c4.add(ch3);
    c4.add(chx3);
   
    c5.add(ch4);
    c5.add(chx4);
    
    //f.add(img);
    
   // c.add(f);
//    c.add(img);
    c.add(c1);
    

    c.add(c2);
        

    c.add(c3);
        

    c.add(c4);
        

    c.add(c5);
 
    c.add(deco);
    k.add(c);
    
    }

    public Form getK() {
        return k;
    }

    public void setK(Form k) {
        this.k = k;
    }
    
    
}
