/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.GUI;

import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.Entity.User;
import com.mycompany.Service.UserService;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author user
 */
public class MdpO {
    Form f ;
    UserService us = new UserService ();
    User u = new User();
    TextField username;
    Button b ;
public MdpO (Resources theme){
    f = new Form ("Mdp oublié",BoxLayout.y());
    f.setUIID("formLogin");
    Login a = new Login (theme);
     f.getToolbar().addCommandToLeftBar("back", theme.getImage("back-command.png"), e -> a.show());
    Label ch = new Label("Nom d'utilisateur : ");
  ch.setUIID("BlueLabel");
  Label ch2 = new Label("Nouveau mot de passe : ");
  ch.setUIID("BlueLabel");
  Label ch3 = new Label("Confirmer votre mot de passe : ");
  ch.setUIID("BlueLabel");
    username =  new TextField ();
    TextField nouv1 =  new TextField ();
    Button b = new Button("Envoyer le code");
    Label ch1 = new Label("Entrez le code ici : ");
  ch.setUIID("BlueLabel");
  Button bb = new Button ("Valider le code");
    Button bbb = new Button ("Changer");

    TextField code = new TextField();
        TextField nouv = new TextField();

    b.addActionListener((evt) -> {
        u = us.getU(username.getText());
        Message m = new Message(u.getPassword());

        Display.getInstance().sendMessage(new String[] {u.getEmail()}, "Code pour récupération du mot de passe", m);
        f.add(ch1);
        f.add(code);
        f.add(bb);
        f.refreshTheme();
    });
    bb.addActionListener((evt) -> {
        if(code.getText().equals(u.getPassword())){
          f.add(ch2);
          f.add(nouv);
          f.add(ch3);
          f.add(nouv1);
          f.add(bbb);
          f.refreshTheme();
        }
        else {
            Dialog.show("Erreur", "Code incorrecte !!", "OK", "Cancel");
        }
    });
    bbb.addActionListener((evt) -> {
         if (nouv.getText().equals("")||nouv1.getText().equals("")){
                    Dialog.show("Erreur", "Champs vides", "OK", "Cancel");
                }
                else if (! (nouv1.getText()).equals(nouv.getText())){
                     Dialog.show("Erreur", "les deux mdp ne sont pas identiques", "OK", "Cancel");
                }
                else {
         final String salt = BCrypt.gensalt();
            String aa = (BCrypt.hashpw(nouv.getText(), salt));
            String myName = aa;
            char[] myNameChars = myName.toCharArray();
            myNameChars[2] = 'y';
            myName = String.valueOf(myNameChars);
            u.setPassword(myName);
                us.editUser(u);
                Dialog.show("Gratz", "Mot de pass changer avec succées", "OK", "Cancel");

                }
    });
    f.add(ch);
    f.add(username);
    f.add(b);
}

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
    
}
